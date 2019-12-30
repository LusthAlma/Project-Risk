package fr.alma.risk.datatypes.mission;


import fr.alma.risk.datatypes.player.Joueur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;
import java.util.Set;

@Entity
public class MissionElimination extends Mission {
    @Column(name = "CIBLE")
    private Color cible;

    protected MissionElimination() {}

    public MissionElimination(Color cible) {
        super("Vous devez eliminer le joueur "+cible+" ou alors conquerir 25 territoire si le joueur n'est pas présent.");
        this.cible = cible;
    }

    @Override
    public boolean estReussie(Joueur joueur , Set<Joueur> joueurs) {
        for (Joueur j: joueurs
             ) {
            if(cible.equals(j.getCouleur())){
                return (j.nbTerritoiresPossédés() == 0);
            }
        }
        return joueur.getTerritoiresPossedes().size()>=25;
    }
}
