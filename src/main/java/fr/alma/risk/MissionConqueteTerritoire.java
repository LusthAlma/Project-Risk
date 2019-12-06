package fr.alma.risk;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionConqueteTerritoire extends Mission {
    private int nbTerritoires;

    protected MissionConqueteTerritoire() {}

    public MissionConqueteTerritoire(int nbTerritoires) {
        super("Vous devez conquerire "+ nbTerritoires+" territoires.");
        this.nbTerritoires = nbTerritoires;
    }

    @Override
    public boolean estRemplie(Joueur joueur, Set<Joueur> joueurs) {
        return joueur.nbTerritoiresPossédés() >= nbTerritoires;
    }
}
