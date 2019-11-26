package fr.alma.risk;


import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionElimination extends Mission {
    private String cible;

    protected MissionElimination() {}

    public MissionElimination(String objectif, String cible) {
        super(objectif);
        this.cible = cible;
    }

    @Override
    public boolean estRemplie(Joueur joueurDontOnVerifieLaVictoire , Set<Joueur> joueurs) {
        for (Joueur j: joueurs
             ) {
            if(cible.equals(j.getNom())){
                return (j.nbTerritoiresPossédés() == 0);
            }
        }
        return false;
    }
}
