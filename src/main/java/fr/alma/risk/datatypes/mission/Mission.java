package fr.alma.risk.datatypes.mission;


import fr.alma.risk.datatypes.player.Joueur;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "missions")
public abstract class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String objectif;

    protected Mission () {}

    public Mission (String objectif) {
        this.objectif = objectif;
    }

    public abstract boolean estReussie(Joueur joueurDontOnVerifieLaVictoire, Set<Joueur> joueurs);

    public long getId() {
        return id;
    }

    public String getObjectif() {
        return objectif;
    }
}
