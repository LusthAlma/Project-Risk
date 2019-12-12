package fr.alma.risk;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MissionConqueteContinent extends Mission {

    @OneToOne(cascade = CascadeType.ALL)
    private Continent continent1;
    @OneToOne(cascade = CascadeType.ALL)
    private Continent continent2;

    protected MissionConqueteContinent() {}

    public MissionConqueteContinent(Continent continent1, Continent continent2) {
        super("Vous devnez conquerir les continents suivants : "+continent1.getNom()+" et "+continent2.getNom()+".");
        this.continent1=continent1;
        this.continent2=continent2;
    }

    @Override
    public boolean estReussie(Joueur joueur, Set<Joueur> joueurs) {
        return (joueur.getContinentsControles().contains(continent1) && joueur.getContinentsControles().contains(continent2));
    }
}
