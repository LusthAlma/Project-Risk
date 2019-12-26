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
    private ContinentRepository ContinentRepository;
    @Autowired
    private TerritoireRepository TerritoireRepository;
    @Autowired
    private MissionRepository MissionRepository;
    @Autowired
    private final SimpMessagingTemplate template;

    private static List<String> ColorsList = new ArrayList<String>(Arrays.asList("jaune", "rouge", "bleues", "noires", "violettes", "vertes"));


    private List<Joueur> Users = new ArrayList<>();

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

    @MessageMapping("/connect")
    public void connectToGame(String message) {
        LOGGER.info("The user " + message + "is now connected");
        Joueur j = new Joueur(ColorsList.get(Users.size()), message);
        template.convertAndSend("/game-lobby", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Le joueur " + message + " rentre en jeu avec la couleur " + ColorsList.get(Users.size()));


    }
}

