package fr.alma.risk.datatypes.player;


import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.Plateau;
import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.unite.Unite;
import fr.alma.risk.exception.ExceptionNegativeRenforts;
import fr.alma.risk.exception.ExceptionRisk;
import fr.alma.risk.exception.ExceptionTerritoireStillHavePossesseur;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
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


    public Joueur(String nom, Color couleur, String sessionId) {
        this.couleur=couleur;
        this.sessionId=sessionId;
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

    public void setMission(Mission mission) {
        this.mission = mission;
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
     * place une unite sur un territoire
     * @param territoire sur lequel on place l'unite
     * @return vrai si l'unite est placé, faux sinon
     */
    public boolean placerRenfort(Territoire territoire){
        if(retirerRenforts()){
            try {
                getUniteWithoutTerritoire().placer(territoire);
                return true;
            } catch (ExceptionRisk exceptionRisk) {
                System.out.println("Erreur le joueur n'a plus d'unité sans territoire");
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Reduit le nombre de renforts
     * @return vrai si un renfort a pu être retiré, faux sinon
     */
    private boolean retirerRenforts(){
        if(renfortsAPlacer>0){
            renfortsAPlacer--;
            return true;
        }else{
            return false;
        }

    }

    /**
     * Permet de trouver des unites du joueurs qui n'ont pas de territoire
     * @return une unite qui n'a pas de territoire
     * @throws ExceptionRisk si le joueur n'a pas d'unite sans territoire.
     */
    public Unite getUniteWithoutTerritoire() throws ExceptionRisk {
    Iterator<Unite> iterable =   unites.iterator();

    while (iterable.hasNext()){
        if(iterable.next().hasTerritoire()) return iterable.next();
        }
        throw new ExceptionRisk();
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

    /**
     * Permet de savoir le nombre de territoires possèdés.
     * @return
     */
    public int nbTerritoiresPossédés() {
        return this.territoiresPossedes.size();
    }

    public void débuterTour() {
        this.tourEnCours = true;
    }

    /**
     * Permet de vérifier si un joueur a gagné
     * @param joueurs liste des joueurs
     * @return vrai si le joueur a gagné, faux sinon
     */
    public boolean aGagné(Set<Joueur> joueurs) {
        return mission.estReussie(this,joueurs);
    }

}
