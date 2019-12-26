/*package fr.alma.risk;

import fr.alma.risk.datatypes.map.Territoire;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller("/client")
public class ClientWebSocketExchanger extends ClientNetworkExchanger {

    protected ClientWebSocketExchanger(){super();}

    public ClientWebSocketExchanger(ClientFacade facade) {
        super(facade);
    }

    @MessageMapping("/init")
    public void initialisation(String couleur) {
        this.getFacade().initialisation(couleur);
    }

    @MessageMapping("/begin")
    public void debuteTour() {
        this.getFacade().debuteTour();
    }

    @MessageMapping("/result")
    public void resultatCombat() {
        this.getFacade().resultatCombat();
    }

    @MessageMapping("/update")
    public void mettreAJour(Set<Territoire> terrModifies) {
        this.getFacade().mettreAJour(terrModifies);
    }
}
*/