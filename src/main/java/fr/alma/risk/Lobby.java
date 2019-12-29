package fr.alma.risk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lobby {

    private String nom;
    private List<String> joueurs;

    public Lobby(String nom) {
        this.nom = nom;
        this.joueurs = new ArrayList<String>();
    }

    public String getNom() {
        return nom;
    }

    public List<String> getJoueurs() {
        return joueurs;
    }

    public boolean ajouterJoueur(String pseudo) {
        if (!(joueurs.size()>=6)) {
            return joueurs.add(pseudo);
        }
        return false;
    }

    public boolean enleverJoueur(String pseudo) {
        return joueurs.remove(pseudo);
    }
}
