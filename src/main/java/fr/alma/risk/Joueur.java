package fr.alma.risk;


import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Joueur {
    private String nom;
    private Set<Unite> unites;
    private Set<Territoire> territoiresPossedes;
    private Set<Continent> continentsControles;
    private Color couleur;
    private Mission mission;
    private int renfortsAPlacer;
    private boolean tourEnCours;
    private Plateau plateau;
    //private ServerInterface serveur;


    public Joueur(String nom) {
        this.nom = nom;
        this.unites = new HashSet<Unite>();
        this.territoiresPossedes = new HashSet<Territoire>();
        this.continentsControles = new HashSet<Continent>();
        this.renfortsAPlacer = 0;
        this.tourEnCours = false;
    }

    public Set<Continent> getContinentsControles() {
        return continentsControles;
    }

    public void ajouterRenforts(int nbRenforts) {
        this.renfortsAPlacer += nbRenforts;

    }

    public String getNom() {
        return nom;
    }

    public void attribuerMission(Mission mission) {
        this.mission = mission;
    }

    public void attribuerCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void ajouterTerritoire(Territoire territoire) {
        this.territoiresPossedes.add(territoire);
    }

    public int nbTerritoiresPossédés() {
        return this.territoiresPossedes.size();
    }

    //public void placerRenforts();

    public void débuterTour() {
        this.tourEnCours = true;
    }

    public boolean aGagné() {
        Set<Joueur> test = new HashSet<Joueur>();
        test.add(this);
        return mission.estRemplie(this,test);
    }

}
