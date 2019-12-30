package fr.alma.risk;

import fr.alma.risk.datageneration.DataGeneration;
import fr.alma.risk.datageneration.GeneratedData;
import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.exception.ExceptionNegativeRenforts;
import fr.alma.risk.exception.ExceptionTerritoireStillHavePossesseur;
import fr.alma.risk.jpaclasses.accessingdatamysql.ContinentRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.MissionRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.TerritoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.logging.Logger;



@Controller
@RequestMapping(path="/app")
public class WebSocketController {
    @Autowired
    private ContinentRepository continentRepository;
    @Autowired
    private TerritoireRepository territoireRepository;
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private final SimpMessagingTemplate template;

    private static Map<Color,String> colorMap = new HashMap<>();

    private static List<Color> colorsList = new ArrayList<>(Arrays.asList(Color.yellow, Color.red, Color.blue, Color.black, Color.pink, Color.green));

    private List<Joueur> users = new ArrayList<>();

    private Map<String, Joueur> usersMap = new HashMap<>();

    private List<String> check = new ArrayList<>();

    @Autowired
    WebSocketController(SimpMessagingTemplate template) {

        this.template = template;


    }

    private static final Logger LOGGER = Logger.getLogger(WebSocketController.class.getName());

    private static Partie jeu;

    public List<Joueur> getUsers() {
        return users;
    }

    @MessageMapping("/send/message")
    public void onReceivedMessage(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        this.template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "" + message);
    }

    @MessageMapping("/ready")
    public void readyToStart(@Header("simpSessionId") String sessionId){
        boolean isConnected=false;
        if(usersMap.containsKey(sessionId)){
            isConnected=true;
        }

        if(isConnected){
            String currentPlayer = usersMap.get(sessionId).getNom();
            if(!check.contains(sessionId)){
                check.add(sessionId);
                template.convertAndSend("/game-lobby",  currentPlayer + " est pret");
            }else{
                LOGGER.info(currentPlayer + "est déjà pret");
            }
        }else{
            LOGGER.info("Vous devez etre connecté pour pouvoir etre pret.");
        }


    }

    @MessageMapping("/connect")
    public void connectToGame(@Header("simpSessionId") String sessionId, String message) {
        initializeColors();
        boolean ready = false;
        if(users.size() < 6 && !usersMap.containsKey(sessionId)) {
            LOGGER.info("The user " + message + "is now connected");
            Joueur j = new Joueur(message, colorsList.get(users.size()), sessionId);
            usersMap.put(sessionId,j);

            template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Le joueur " + message + " rentre en jeu avec la couleur " + colorMap.get(colorsList.get(users.size())));
            users.add(j);
        }
        else
            template.convertAndSend("/game-lobby", "Le lobby est plein ou vous etes deja connecte");

        while(!ready){
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException interupt){}
            if (users.size() == 6 || (users.size()>= 3 && check.size() == users.size())){
                ready=true;
            }

        }

        template.convertAndSend("/game-lobby", "La partie va commencer");
        /* Jeu.start() */
        List<Joueur> temp = new ArrayList<>(users);
        users.clear();
        usersMap.clear();
        check.clear();
        initialisation(temp);


    }

    private void initializeColors(){
        colorMap.put(Color.yellow,"Jaune");
        colorMap.put(Color.red,"Rouge");
        colorMap.put(Color.black,"Noire");
        colorMap.put(Color.blue,"Bleu");
        colorMap.put(Color.green,"Verte");
        colorMap.put(Color.pink,"Rose");

    }

    private void initialisation(List<Joueur> joueurs){
        LOGGER.info("Initialisation de la partie");
        jeu = new Partie(1, joueurs);

        LOGGER.info("Génération des données de base du Risk");
        GeneratedData datas = DataGeneration.generate();
        Set<Continent> continents = datas.getContinents();
        Set<Territoire> territoires = datas.getTerritoires();
        Set<Mission> missions = datas.getMissions();

        LOGGER.info("Ajout des missions");
        missionRepository.saveAll(missions);
        LOGGER.info("Ajout des continents");
        continentRepository.saveAll(continents);
        LOGGER.info("Ajout des territoires");
        territoireRepository.saveAll(territoires);


        donnerMissionTousLesJoueurs(joueurs);

        donnerTerritoiresTousLesJoueurs(joueurs);

        donnerRenfortsAuxJoueurs(joueurs);

        placerUniteChaqueTerritoire(joueurs);


    }

    private void placerUniteChaqueTerritoire(List<Joueur> joueurs) {
        territoireRepository.findAll().forEach(territoire -> {
            if(territoire.hasPossesseur()){
                territoire.getPossesseur().placerRenfort(territoire);
                LOGGER.info("Placement d'une unité de "+territoire.getPossesseur().getNom()+"sur le territoire "+territoire.getNom());
            }
        });
        for (Joueur joueur:joueurs
             ) {
            template.convertAndSend("/game-lobby", "Il reste "+joueur.getRenfortsAPlacer()+"unités à placer pour le joueur "+joueur.getNom());
        }
    }

    private void donnerTerritoiresTousLesJoueurs(List<Joueur> joueurs) {
        List<Territoire> territoireList = new ArrayList<>();
        territoireRepository.findAll().forEach(territoire -> {
            territoireList.add(territoire);
        });
        Collections.shuffle(territoireList);

        while(territoireList.size()>0){
            for (Joueur j:joueurs
            ) {
                if(territoireList.size()>0){
                    donnerTerritoireUnJoueur(territoireList.remove(0),j);
                }
            }
        }
        template.convertAndSend("/game-lobby", "Les territoires ont été distribués aux joueurs");
    }

    private void donnerTerritoireUnJoueur(Territoire territoire, Joueur joueur) {
        try {
            joueur.ajouterTerritoire(territoire);
            LOGGER.info("Le territoire "+ territoire.getNom()+" vient d'être attribué à "+joueur.getNom());
        } catch (ExceptionTerritoireStillHavePossesseur exceptionTerritoireStillHavePossesseur) {
            LOGGER.info("Le territoire "+ territoire.getNom()+" appartient déja à "+territoire.getPossesseur().getNom()+" et vient d'être attribué à "+ joueur.getNom());
            exceptionTerritoireStillHavePossesseur.printStackTrace();
        }
    }

    private void donnerRenfortsAuxJoueurs(List<Joueur> joueurs) {
        for (Joueur joueur:joueurs) {
            donnerRenfortUnJoueur(joueur,joueurs);
        }
    }

    private void donnerRenfortUnJoueur(Joueur joueur,List<Joueur> joueurs) {
        try {
            joueur.ajouterRenforts((10-joueurs.size())*5);
            template.convertAndSend("/game-lobby", "Le joueur "+joueur.getNom()+" a reçu ses " + (10-users.size())*5 +" renforts.");
        } catch (ExceptionNegativeRenforts exceptionNegativeRenforts) {
            LOGGER.info("Problème initialisation des renforts, il y a plus de 9 joueurs, hors la limite est de 6 normalement.");
            exceptionNegativeRenforts.printStackTrace();
        }
    }

    private void donnerMissionTousLesJoueurs(List<Joueur> joueurs) {
        List<Mission> missionsList = new ArrayList<>();
        missionRepository.findAll().forEach(mission -> {
            missionsList.add(mission);
        });

        Collections.shuffle(missionsList);
        Mission givenMission;
        for (Joueur joueur:joueurs
             ) {
            donnerMissionUnJoueur(missionsList.remove(0), joueur);
        }
    }

    private void donnerMissionUnJoueur(Mission mission, Joueur joueur) {
        joueur.setMission(mission);
        LOGGER.info("Le joueur "+joueur.getNom()+" à pour objectif : "+mission.getObjectif());
        template.convertAndSend("/game-lobby", "Le joueur "+joueur.getNom()+" a reçu sa mission");
    }
}

