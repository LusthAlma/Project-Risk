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
<<<<<<< HEAD
    @Transient
    private Set<Unité> unitésDéployées;
    @Transient
=======
    private Set<Unite> unitesDeployees;
>>>>>>> 19225e41d3a954d1d182dbc12f076d25955df784
    private Set<Territoire> voisins;

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
