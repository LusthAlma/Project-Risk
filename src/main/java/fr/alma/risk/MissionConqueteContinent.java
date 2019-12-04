package fr.alma.risk;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionConqueteContinent extends Mission {
    private String continents1,continents2;

    protected MissionConqueteContinent() {}

    public MissionConqueteContinent(String continents1, String continents2) {
        super("Vous devez conquérire les territoires suivants : "+continents1+" et "+ continents2+".");
        this.continents1 = continents1;
        this.continents2 = continents2;
    }

    @Override
    public boolean estRemplie(Joueur joueur, Set<Joueur> joueurs) {
        return (joueur.getContinentsControlés().contains(continents1) && joueur.getContinentsControlés().contains(continents2));
    }
}
