package fr.alma.risk.datatypes.map;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

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
        for (Territoire territoire:territoires
             ) {
            territoire.setContinent(this);
        }
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

    /**
     * Permet d'ajouter un territoire à la liste des territoires du continent
     * @param territoire à ajouter
     * @return renvoit vrai s'il n'était pas déja présent dans l'ensemble et qu'il a bien été ajouté.
     */
    public boolean addTerritoire(Territoire territoire){
        return territoires.add(territoire);
    }

    /**
     * Permet d'ajouter un ensemble de territoire à la liste des territoires du continent
     * @param territoires à ajouter
     * @return renvoit vrai s'ils n'étaient pas déja présent dans l'ensemble et s'ils ont bien été ajoutés.
     */
    public boolean addTerritoire(Set<Territoire> territoires){
        return this.territoires.addAll(territoires);
    }

    /**
     * Permet de retirer un territoire du continent
     * @param territoire à retirer
     * @return renvoit vrai s'il était présent et a donc été retiré
     */
    public boolean removeTerritoire(Territoire territoire){
        return territoires.remove(territoire);
    }

    /**
     * Permet de retirer un ensemble de territoire du continent
     * @param territoires à retirer
     * @return renvoit vrai s'ils étaient présent et ont donc été retirés
     */
    public boolean removeTerritoire(Set<Territoire> territoires){
        return this.territoires.remove(territoires);
    }

}
