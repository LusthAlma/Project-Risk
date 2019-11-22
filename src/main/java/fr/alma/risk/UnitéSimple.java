package fr.alma.risk;

public class UnitéSimple extends Unité {

    public UnitéSimple(Joueur joueur) {
        super();
        this.setValeur(1);
        this.setJoueur(joueur);
    }

    @Override
    public void déplacer(Territoire arrivée) {
        this.setTerritoire(arrivée);
    }
}
