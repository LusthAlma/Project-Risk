package fr.alma.risk;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MissionConqueteContinent extends Mission {

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id")
    private Set<Continent> continents;

    protected MissionConqueteContinent() {}

    public MissionConqueteContinent(Set<Continent> continents) {
        super("Vous devnez conquerir les territoires suivants : ");
        this.continents = continents;
    }

    @Override
    public boolean estRemplie(Joueur joueur, Set<Joueur> joueurs) {
        return joueur.getContinentsControles().containsAll(continents);
    }
}
