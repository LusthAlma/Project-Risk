package fr.alma.risk;

import fr.alma.risk.datageneration.DataGeneration;
import fr.alma.risk.datageneration.GeneratedData;
import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.exception.ExceptionNegativeRenforts;
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



    @MessageMapping("/send/message")
    public void onReceivedMessage(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        this.template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + message);
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
            if (users.size() == 6 || (users.size()>= 2 && check.size() == users.size())){
                ready=true;
            }

        }

        template.convertAndSend("/game-lobby", "La partie va commencer");
        /* Jeu.start() */
        List<Joueur> temp = new ArrayList<>(users);
        users.clear();
        check.clear();
        initialisation(temp);


    }

    public void initializeColors(){
        colorMap.put(Color.yellow,"Jaune");
        colorMap.put(Color.red,"Rouge");
        colorMap.put(Color.black,"Noire");
        colorMap.put(Color.blue,"Bleu");
        colorMap.put(Color.green,"Verte");
        colorMap.put(Color.pink,"Rose");

    }

    public void initialisation(List<Joueur> joueurs){
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


        donnerMissionTousLesJoueurs();
        donnerRenfortsDeBase();


    }

    private void donnerRenfortsDeBase() {
        for (Joueur joueur:users) {
            try {
                joueur.ajouterRenforts((10-users.size())*5);
            } catch (ExceptionNegativeRenforts exceptionNegativeRenforts) {
                LOGGER.info("Problème initialisation des renforts, il y a plus de 9 joueurs, hors la limite est de 6 normalement.");
                exceptionNegativeRenforts.printStackTrace();
            }
        }
    }

    private void donnerMissionTousLesJoueurs() {
        List<Mission> missionsList = new ArrayList<>();
        missionRepository.findAll().forEach(mission -> {
            missionsList.add(mission);
        });

        Collections.shuffle(missionsList);
        Mission givenMission;
        for (Joueur joueur:users
             ) {
            donnerMissionUnJoueur(missionsList.remove(0), joueur);
        }
    }

    private void donnerMissionUnJoueur(Mission mission, Joueur joueur) {
        joueur.setMission(mission);
    }
}

