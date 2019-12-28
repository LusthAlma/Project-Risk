package fr.alma.risk;

public class WebSocketNetworkExchanger implements NetworkExchanger {

    private ServerFacade facade;

    protected WebSocketNetworkExchanger(){}

    public WebSocketNetworkExchanger(ServerFacade facade) {
        this.facade = facade;
    }

    @Override
    public void send(String message) {

    }

    public ServerFacade getFacade() {
        return facade;
    }


}
