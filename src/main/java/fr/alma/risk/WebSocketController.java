package fr.alma.risk;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/*@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path="/app")
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template=template;
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @MessageMapping("/connect")
    @SendTo("/game-lobby")
    public void onReceivedMessage(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        this.template.convertAndSend("/game-lobby",new SimpleDateFormat("HH:mm:ss").format(new Date())+message);
    }

}
*/
@Controller
public class WebSocketController {


    @MessageMapping("/hello")
    @SendTo("/game-lobby/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
