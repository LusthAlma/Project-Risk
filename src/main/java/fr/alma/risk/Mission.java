package fr.alma.risk;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String objectif;

    protected Mission () {}

    public Mission (String objectif) {
        this.objectif = objectif;
    }

    public abstract boolean estRemplie(Joueur joueur);

    public long getId() {
        return id;
    }

    public String getObjectif() {
        return objectif;
    }
}
