package fr.alma.risk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServerFacade {

    private Set<Partie> parties;
    private Set<Lobby> lobbies;

    public ServerFacade(){
        this.parties = new HashSet<Partie>();
        this.lobbies = new HashSet<Lobby>();
    }

    public void seConnecter(String pseudo){

    }

    public void deployerUnite(int nbUnit, String territoire){

    }

    public void deplacer(int nbUnit, String depart, String arrivee){

    }

    public void finirTour(String pseudo){

    }

    public void creerLobby(String createur, String nomLobby) {
        Lobby newLobby = new Lobby(nomLobby);
        newLobby.ajouterJoueur(createur);
        lobbies.add(newLobby);
    }

    public boolean rejoindreLobby(String pseudo, String nomLobby) {
        Iterator itr = lobbies.iterator();
        boolean found = false;
        while (itr.hasNext() && !found) {
            Lobby current = (Lobby) itr.next();
            if (current.getNom().equals(nomLobby)) {
                found = true;
                return current.ajouterJoueur(pseudo);
            }
        }
        return false;
    }


}
