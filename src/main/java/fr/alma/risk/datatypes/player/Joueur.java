package fr.alma.risk.datatypes.player;


import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.Plateau;
import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.unite.Unite;
import fr.alma.risk.exception.ExceptionNegativeRenforts;
import fr.alma.risk.exception.ExceptionTerritoireStillHavePossesseur;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Joueur {
    private String sessionId;
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


    public Joueur(String nom, String sessionId) {
        this.sessionId = sessionId;
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

    public String getNom() {
        return nom;
    }

    public Mission getMission() {
        return mission;
    }

    public int getRenfortsAPlacer() {
        return renfortsAPlacer;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Set<Territoire> getTerritoiresPossedes() {
        return territoiresPossedes;
    }

    public String getSessionId(){return sessionId;}

    /**
     * ajouter des renforts au joueur.
     * @param nbRenforts est la valeur a ajouter la valeur actuelle du joueur.
     * @throws ExceptionNegativeRenforts si le paramètre nbRenforts est négatif.
     */
    public void ajouterRenforts(int nbRenforts) throws ExceptionNegativeRenforts {
        if(nbRenforts<0) throw new ExceptionNegativeRenforts();
        this.renfortsAPlacer += nbRenforts;
    }

    /**
     * attribue une mission à un joueur
     * @param mission à attribuer a un joueur.
     */
    public void attribuerMission(Mission mission) {
        this.mission = mission;
    }

    /**
     * attribue une couleur à un joueur
     * @param couleur à attribuer au joueur.
     */
    public void attribuerCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * Permet d'ajouter un terrtoire a la liste des territoires possèdé par un joueur.
     * @param territoire à ajouter au joueur.
     * @throws ExceptionTerritoireStillHavePossesseur si le territoire est déja possedé par quelqu'un
     */
    public void ajouterTerritoire(Territoire territoire) throws ExceptionTerritoireStillHavePossesseur {
        if(territoire.getPossesseur() == null){
            this.territoiresPossedes.add(territoire);
            territoire.setPossesseur(this);
        }else{
            throw new ExceptionTerritoireStillHavePossesseur();
        }

    }

    public int nbTerritoiresPossédés() {
        return this.territoiresPossedes.size();
    }

    public void débuterTour() {
        this.tourEnCours = true;
    }

    public boolean aGagné() {
        Set<Joueur> test = new HashSet<Joueur>();
        test.add(this);
        return mission.estReussie(this,test);
    }

}
