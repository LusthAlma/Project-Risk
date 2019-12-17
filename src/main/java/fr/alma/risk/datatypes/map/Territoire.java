package fr.alma.risk.datatypes.map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.datatypes.unite.Unite;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "territoires")
public class Territoire {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NOM")
    private String nom;
    @Transient
    private Joueur possesseur;
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
    private Continent continent;

    protected Territoire(){}

    public Territoire(String nom){
        this.nom = nom;
        this.voisins = new HashSet<>();
        this.unitesDeployees = new HashSet<>();
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

    public Set<Unite> getUnitesDeployees() {
        return unitesDeployees;
    }

    public Set<Territoire> getVoisins() {
        return voisins;
    }

    public boolean ajoutUnite(Unite unite){
        return this.unitesDeployees.add(unite);
    }

    /**
     * Ajoute un voisin a l'ensemble des voisins, et ajoute a ce voisin ce territoire a son ensemble des voisins
     * @param voisin à ajouter à l'ensemble et dont on va ajouter ce territoire à son ensemble
     * @return renvoit vrai si le voisin est ajouté a l'ensemble et que le voisin ajoute ce territoire à son ensemble.
     */
    public boolean ajoutVoisin(Territoire voisin){
        if(voisin==this) return false;
        return (this.ajoutBasiqueVoisin(voisin) && voisin.ajoutBasiqueVoisin(this));
    }

    /**
     * Ajout simple d'un voisin a son ensemble des voisins
     * @param voisin à ajouter à l'ensemble
     * @return renvoit vrai si l'ensemble ne contenait pas déja le voisin et qu'il a donc été ajouté.
     */
    private boolean ajoutBasiqueVoisin(Territoire voisin){
        return this.voisins.add(voisin);
    }
}
