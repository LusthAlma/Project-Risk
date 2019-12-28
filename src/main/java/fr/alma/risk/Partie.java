package fr.alma.risk;

import fr.alma.risk.datatypes.Plateau;
import fr.alma.risk.datatypes.player.Joueur;

import java.util.Set;

public class Partie {

    private int id;
    private Set<Joueur> joueurs;
    private Plateau plateau;

    public Partie(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
