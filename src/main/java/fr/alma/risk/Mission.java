package fr.alma.risk;


import javax.persistence.*;
import java.util.Set;

@Entity
public abstract class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "OBJECTIF")
    private String objectif;

    protected Mission () {}

    public Mission (String objectif) {
        this.objectif = objectif;
    }

    public abstract boolean estRemplie(Joueur joueurDontOnVerifieLaVictoire, Set<Joueur> joueurs);

    public long getId() {
        return id;
    }

    public String getObjectif() {
        return objectif;
    }
}
