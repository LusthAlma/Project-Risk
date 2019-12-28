package fr.alma.risk;

import java.util.HashSet;
import java.util.Set;

public class Lobby {

    private String nom;
    private Set<String> joueurs;

    public Lobby(String nom) {
        this.nom = nom;
        this.joueurs = new HashSet<String>();
    }

    public String getNom() {
        return nom;
    }

    public Set<String> getJoueurs() {
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
