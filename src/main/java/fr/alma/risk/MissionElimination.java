package fr.alma.risk;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class MissionElimination extends Mission {
    @Column(name = "CIBLE")
    private String cible;

    protected MissionElimination() {}

    public MissionElimination(String cible) {
        super("Vous devez eliminer le joueur "+cible+"ou alors conquerir 25 territoire si le joueur n'est pas présent.");
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
