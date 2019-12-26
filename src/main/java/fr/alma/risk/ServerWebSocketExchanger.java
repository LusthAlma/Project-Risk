package fr.alma.risk;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller("/server")
public class ServerWebSocketExchanger extends ServerNetworkExchanger {

    protected ServerWebSocketExchanger(){super();}

    public ServerWebSocketExchanger(ServerFacade facade) {
        super(facade);
    }

    @MessageMapping("/connect")
    public void seConnecter(String pseudo){
        this.getFacade().seConnecter(pseudo);
    }

    @MessageMapping("/deploy")
    public void deployerUnite(int nbUnit, String territoire){
        this.getFacade().deployerUnite(nbUnit, territoire);
    }

    @MessageMapping("/move")
    public void deplacer(int nbUnit, String depart, String arrivee){
        this.getFacade().deplacer(nbUnit, depart, arrivee);
    }

    @MessageMapping("/end")
    public void finirTour(String pseudo){
        this.getFacade().finirTour(pseudo);
    }
}