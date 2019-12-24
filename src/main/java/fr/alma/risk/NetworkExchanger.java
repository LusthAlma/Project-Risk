package fr.alma.risk;

public abstract class NetworkExchanger {

    private Facade facade;

    public NetworkExchanger(Facade facade) {
        this.facade = facade;
    }

    public abstract void send(String message);

}
