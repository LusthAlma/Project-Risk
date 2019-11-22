package fr.alma.risk;

public class MissionElimination extends Mission {
    private Joueur cible;

    public MissionElimination(String objectif, Joueur cible) {
        super(objectif);
        this.cible = cible;
    }

    public boolean estRemplie(Joueur joueur) {
        return cible.nbTerritoiresPossédés() == 0;
    }
}
