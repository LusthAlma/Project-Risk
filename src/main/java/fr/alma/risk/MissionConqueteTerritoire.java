public class MissionConqueteTerritoire extends Mission {
    private int nbTerritoires;

    public MissionConqueteTerritoire(String objectif, int nbTerritoires) {
        super(objectif);
        this.nbTerritoires = nbTerritoires;
    }

    @Override
    public boolean estRemplie(Joueur joueur) {
        return joueur.nbTerritoiresPossédés() >= nbTerritoires;
    }
}
