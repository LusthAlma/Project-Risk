import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Joueur {
    private String nom;
    private Set<Unité> unités;
    private Set<Territoire> territoiresPossédés;
    private Set<Continent> continentsControlés;
    private Color couleur;
    private Mission mission;
    private int renfortsAPlacer;
    private boolean tourEnCours;
    private Plateau plateau;
    private ServerInterface serveur;

    public Joueur(String nom) {
        this.nom = nom;
        this.unités = new HashSet<Unité>();
        this.territoiresPossédés = new HashSet<Territoire>();
        this.continentsControlés = new HashSet<Continent>();
        this.renfortsAPlacer = 0;
        this.tourEnCours = false;
    }

    public Set<Continent> getContinentsControlés() {
        return continentsControlés;
    }

    public void ajouterRenforts(int nbRenforts) {
        this.renfortsAPlacer += nbRenforts;

    }

    public void attribuerMission(Mission mission) {
        this.mission = mission;
    }

    public void attribuerCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void ajouterTerritoire(Territoire territoire) {
        this.territoiresPossédés.add(territoire);
    }

    public int nbTerritoiresPossédés() {
        return this.territoiresPossédés.size();
    }

    //public void placerRenforts();

    public void débuterTour() {
        this.tourEnCours = true;
    }

    public boolean aGagné() {
        return mission.estRemplie(this);
    }

}
