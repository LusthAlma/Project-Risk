package fr.alma.risk.datatypes.mission;

import fr.alma.risk.datatypes.player.Joueur;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionConqueteTerritoire extends Mission {
    @Column(name = "NBTERRITOIRES")
    private int nbTerritoires;

    protected MissionConqueteTerritoire() {}

    public MissionConqueteTerritoire(int nbTerritoires) {
        super("Vous devez conquerir "+ nbTerritoires+" territoires.");
        this.nbTerritoires = nbTerritoires;
    }

    @Override
    public boolean estReussie(Joueur joueur, Set<Joueur> joueurs) {
        return joueur.nbTerritoiresPossédés() >= nbTerritoires;
    }
}
