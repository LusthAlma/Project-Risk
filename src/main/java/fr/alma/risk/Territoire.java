package fr.alma.risk;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Territoire {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nom;
    @Transient
    private Joueur possesseur;
    @Transient
    private Set<Unite> unitésDéployées;
    @Transient
    private Set<Unite> unitesDeployees;
    @Transient
    private Set<Territoire> voisins;
    @ManyToOne
    Continent continent;

    protected Territoire(){}

    public Territoire(String nom, Set<Territoire> voisins) {
        this.nom =  nom;
        this.voisins = voisins;
    }

    public Territoire(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
