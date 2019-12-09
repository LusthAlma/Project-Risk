package fr.alma.risk;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nom;
    @Column
    private int renfortsBonus;
    @Transient
    private Set<Territoire> territoires;

    protected Continent(){}

    public Continent(String nom, int renfortsBonus, Set<Territoire> territoires) {
        this.nom = nom;
        this.renfortsBonus = renfortsBonus;
        this.territoires = territoires;
    }

    public Continent(String nom, int renfortsBonus){
        this.nom=nom;
        this.renfortsBonus=renfortsBonus;
    }

    public String getNom() {
        return nom;
    }
}
