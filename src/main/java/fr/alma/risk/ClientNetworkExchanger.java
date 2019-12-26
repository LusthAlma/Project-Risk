package fr.alma.risk;

public class ClientNetworkExchanger implements NetworkExchanger {

    private ClientFacade facade;

    protected ClientNetworkExchanger(){}

    public ClientNetworkExchanger(ClientFacade facade) {
        this.facade = facade;
    }

    @Override
    public void send(String message) {

    }

    public ClientFacade getFacade() {
        return facade;
    }
}
