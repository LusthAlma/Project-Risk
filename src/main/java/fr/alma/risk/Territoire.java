package fr.alma.risk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Territoire {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NOM")
    private String nom;
    @Transient
    private Joueur possesseur;
    @Transient
    private Set<Unite> unitésDéployées;
    @Transient
    private Set<Unite> unitesDeployees;
    @JsonIgnoreProperties("voisins") // EDIT: will prevent the infinite recursion
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "VOISINS",
            joinColumns = @JoinColumn(name = "territoire_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "voisin_id",
                    referencedColumnName = "id"))
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
        this.voisins = new HashSet<>();
    }

    public boolean sontVoinsins(Territoire voisin){
        return (voisins.add(voisin) && voisin.sontVoinsins(this));
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getNom() {
        return nom;
    }

    public Joueur getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(Joueur possesseur) {
        this.possesseur = possesseur;
    }
}
