package fr.alma.risk.datatypes.map;

import javax.persistence.*;
import java.util.HashSet;
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
        setAllContinentParameterOfTerritoireToThis(territoires);
    }

    public Continent(String nom, int renfortsBonus){
        this.nom=nom;
        this.renfortsBonus=renfortsBonus;
        this.territoires =  new HashSet<>();
    }

    public String getNom() {
        return nom;
    }

    public int getRenfortsBonus() {
        return renfortsBonus;
    }

    /**
     * Permet de savoir si le continent contient ou non le territoire.
     * @param territoire dont on vérifie l'appartenance
     * @return vrai s'il contient le territoire, faux sinon.
     */
    public boolean containsTerritoire(Territoire territoire){
        return territoires.contains(territoire);
    };

    /**
     * Permet de savoir si le continent contient les territoires
     * @param territoires dont on vérifie l'appartenance
     * @return vrai s'il contient tous les territoires, faux sinon
     */
    public boolean containsAllTerritoire(Set<Territoire> territoires){
        return territoires.containsAll(territoires);
    }

    private void setAllContinentParameterOfTerritoireToThis(Territoire territoire) {
        territoire.setContinent(this);
    }

    private void setAllContinentParameterOfTerritoireToThis(Set<Territoire> territoires) {
        for (Territoire territoire:territoires
             ) {
            territoire.setContinent(this);
        }
    }

    private void setAllContinentParmeterOFTerritoireToNull(Territoire territoire){
        territoire.setContinent(null);
    }

    private void setAllContinentParmeterOFTerritoireToNull(Set<Territoire> territoires){
        for (Territoire territoire:territoires
        ) {
            territoire.setContinent(null);
        }
    }

    /**
     * Permet d'ajouter un territoire à la liste des territoires du continent
     * @param territoire à ajouter
     * @return renvoit vrai s'il n'était pas déja présent dans l'ensemble et qu'il a bien été ajouté.
     */
    public boolean addTerritoire(Territoire territoire){
        if(this.territoires.add(territoire)){
            setAllContinentParameterOfTerritoireToThis(territoire);
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Permet d'ajouter un ensemble de territoire à la liste des territoires du continent
     * @param territoires à ajouter
     * @return renvoit vrai s'ils n'étaient pas déja présent dans l'ensemble et s'ils ont bien été ajoutés.
     */
    public boolean addTerritoire(Set<Territoire> territoires){
        if(this.territoires.addAll(territoires)){
            setAllContinentParameterOfTerritoireToThis(territoires);
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Permet de retirer un territoire du continent
     * @param territoire à retirer
     * @return renvoit vrai s'il était présent et a donc été retiré
     */
    public boolean removeTerritoire(Territoire territoire){
        if(this.territoires.remove(territoire)){
            setAllContinentParmeterOFTerritoireToNull(territoire);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Permet de retirer un ensemble de territoire du continent
     * @param territoires à retirer
     * @return renvoit vrai s'ils étaient présent et ont donc été retirés
     */
    public boolean removeTerritoire(Set<Territoire> territoires){
        boolean res=true;
        for (Territoire territoire:territoires
             ) {
            res = res && this.territoires.remove(territoire);
            setAllContinentParmeterOFTerritoireToNull(territoire);
        }
        return res;
    }

    private boolean allTerritoireHasThisAsContinent(){
        for (Territoire territore:territoires
             ) {
           if(territore.getContinent() != this){
               return false;
           }
        }
        return true;
    }

}
