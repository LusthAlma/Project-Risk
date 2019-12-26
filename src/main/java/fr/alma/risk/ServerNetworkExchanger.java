package fr.alma.risk;

public class ServerNetworkExchanger implements NetworkExchanger {

    private ServerFacade facade;

    protected ServerNetworkExchanger(){}

    public ServerNetworkExchanger(ServerFacade facade) {
        this.facade = facade;
    }

    @Override
    public void send(String message) {

    }

    public ServerFacade getFacade() {
        return facade;
    }


}
