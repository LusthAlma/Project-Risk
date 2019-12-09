package fr.alma.risk;

public class UniteSimple extends Unite {

    public UniteSimple(Joueur joueur) {
        super();
        this.setValeur(1);
        this.setJoueur(joueur);
    }

    @Override
    public void deplacer(Territoire arrivee) {
        this.setTerritoire(arrivee);
    }
}
