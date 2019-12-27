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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    private static List<Color> colorsList = new ArrayList<>(Arrays.asList(Color.yellow, Color.red, Color.blue, Color.black, Color.pink, Color.green));


    private List<Joueur> users = new ArrayList<>();

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
        if(!check.contains(sessionId)){
            check.add(sessionId);
            template.convertAndSend("/game-lobby", "le joueur " + check.size() + " est prêt");
        }
        LOGGER.info("vous êtes déjà prêt");
    }

    @MessageMapping("/connect")
    public void connectToGame(@Header("simpSessionId") String sessionId, String message) {
        boolean ready = false;
        if(users.size() < 6) {
            LOGGER.info("The user " + message + "is now connected");
            Joueur j = new Joueur(message, colorsList.get(users.size()), sessionId);

            template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Le joueur " + message + " rentre en jeu avec la couleur " + colorsList.get(users.size()).toString());
            users.add(j);
        }
        else
            template.convertAndSend("/game-lobby", "Le lobby est plein");

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
}
