package fr.alma.risk.datatypes.map;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "RENFORTSBONUS")
    private int renfortsBonus;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "continent", orphanRemoval = true)
    @OrderBy("id")
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

    public int getRenfortsBonus() {
        return renfortsBonus;
    }

}
