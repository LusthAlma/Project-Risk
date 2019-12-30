package fr.alma.risk;

import fr.alma.risk.datatypes.player.Joueur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WebSocketControllerTest {
    SimpMessagingTemplate simpMessagingTemplateMock;
    WebSocketController webSocketControllerTest;
    String sessionIdTest;
    String userNameTest;


    @Before
    public void setup(){
        simpMessagingTemplateMock = Mockito.mock(SimpMessagingTemplate.class);
        webSocketControllerTest = new WebSocketController(simpMessagingTemplateMock);
        sessionIdTest ="test";
        userNameTest = "Test";


    }





}
