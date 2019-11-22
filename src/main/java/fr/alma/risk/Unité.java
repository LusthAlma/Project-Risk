public abstract class Unité {

    private int valeur;
    private Joueur joueur;
    private Territoire territoire;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Territoire getTerritoire() {
        return territoire;
    }

    public void setTerritoire(Territoire territoire) {
        this.territoire = territoire;
    }

    public abstract void déplacer(Territoire arrivée);


}
