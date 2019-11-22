package fr.alma.risk;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionConqueteContinent extends Mission {
    private Set<Continent> continents;

    public MissionConqueteContinent(String objectif, Set<Continent> continents) {
        super(objectif);
        this.continents = continents;
    }

    @Override
    public boolean estRemplie(Joueur joueur) {
        return joueur.getContinentsControlés().containsAll(continents);
    }
}
