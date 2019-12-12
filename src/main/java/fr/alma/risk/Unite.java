package fr.alma.risk;


import fr.alma.risk.exception.ExceptionRisk;
import fr.alma.risk.exception.ExceptionTerritoryCantBeEmpty;
import fr.alma.risk.exception.ExceptionUniteHasNoTerritory;

public abstract class Unite {

    private int valeur;
    private Joueur joueur;
    private Territoire territoire;

    public Unite(int valeur,Joueur joueur){
        this.valeur = valeur;
        this.joueur=joueur;
    }

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

    /**
     * Deplace une unité vers un territoire et verifie si elle ne laisse pas le territoire vide.
     * @param arrivee ou arrive l'unité
     * @return renvoit vraie si l'unité est déplacé, faux sinon
     */
    public boolean deplacer(Territoire arrivee) throws ExceptionUniteHasNoTerritory, ExceptionTerritoryCantBeEmpty {
        if(this.getTerritoire() == null) throw new ExceptionUniteHasNoTerritory();
        if(this.getTerritoire().getUnitesDeployees().size()>1) {
            this.setTerritoire(arrivee);
            return true;
        }else{
            throw new ExceptionTerritoryCantBeEmpty();
        }
    }

    /**
     * Place une unité sur un territoire
     * @param territoire ou est placé l'unité
     */
    public void placer(Territoire territoire){
        this.setTerritoire(territoire);
        territoire.ajoutUnite(this);
    }




}
