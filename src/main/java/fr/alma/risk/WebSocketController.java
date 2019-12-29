package fr.alma.risk;

import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.jpaclasses.accessingdatamysql.ContinentRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.MissionRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.TerritoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.jws.soap.SOAPBinding;
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



    @MessageMapping("/send/message")
    public void onReceivedMessage(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        this.template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + message);
    }

    @MessageMapping("/ready")
    public void readyToStart(@Header("simpSessionId") String sessionId){
        boolean isConnected=false;
        Joueur currentPlayer = null;
        int playerIndex=-1;

        for(int i=0;i<users.size();i++){
            if(users.get(i).getSessionId()==sessionId){
                isConnected = true;
                currentPlayer = users.get(i);
                playerIndex = i;
            }
        }
        if(isConnected){
            if(!check.contains(sessionId)){
                check.add(sessionId);
                template.convertAndSend("/game-lobby", "le joueur " + (playerIndex+1) + " est prêt");
            }else{
                LOGGER.info(currentPlayer.getNom() +"est déjà prêt");
            }
        }else{
            LOGGER.info("Vous devez être connecté pour pouvoir être prêt.");
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
        users.clear();
        check.clear();


    }

    public void initializeColors(){
        colorMap.put(Color.yellow,"Jaune");
        colorMap.put(Color.red,"Rouge");
        colorMap.put(Color.black,"Noire");
        colorMap.put(Color.blue,"Bleu");
        colorMap.put(Color.green,"Verte");
        colorMap.put(Color.pink,"Rose");

    }
}

