package fr.alma.risk;

import fr.alma.risk.datatypes.Plateau;
import fr.alma.risk.datatypes.player.Joueur;

import java.util.List;
import java.util.Set;

public class Partie {

    private int id;
    private List<Joueur> joueurs;
    private Plateau plateau;

    public Partie(int id, List<Joueur> joueurs) {
        this.joueurs=joueurs;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
