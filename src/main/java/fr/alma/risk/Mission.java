package fr.alma.risk;

public abstract class Mission {
    private String objectif;

    public Mission (String objectif) {
        this.objectif = objectif;
    }

    public abstract boolean estRemplie(Joueur joueur);
}
