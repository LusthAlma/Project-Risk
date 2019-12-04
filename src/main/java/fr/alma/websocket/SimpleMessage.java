package fr.alma.websocket;

public class SimpleMessage {

    private String name;

    public SimpleMessage(){

    }

    public SimpleMessage(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

}
