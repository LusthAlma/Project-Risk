package fr.alma.risk;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


import fr.alma.risk.datatypes.Joueur;
import fr.alma.risk.datatypes.Mission;
import fr.alma.risk.datatypes.MissionElimination;
import fr.alma.risk.datatypes.Territoire;
import fr.alma.risk.exception.ExceptionNegativeRenforts;
import fr.alma.risk.exception.ExceptionTerritoireStillHavePossesseur;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class JoueurTest {

    private Joueur joueurNamedTest;
    private Joueur joueurNamedOther;
    private Territoire territoireNamedTest;
    private Mission missionEliminationRouge;
    private Color colorNoir;
    private static final int VALUEMINUS10 = -10;
    private static final int VALUE0 = 0;
    private static final int VALUE10 = 10;

    @Before
    public void setup(){
        joueurNamedTest = new Joueur("Test");
        joueurNamedOther = new Joueur("Other");
        territoireNamedTest = new Territoire("Test");
        missionEliminationRouge = new MissionElimination("Rouge");
        colorNoir = Color.BLACK;

    }

    //ajouterRenforts
    @Test
    public void testAjouterRenfortsAddValueWithPositiveInteger() throws ExceptionNegativeRenforts {
        joueurNamedTest.ajouterRenforts(VALUE10);
        assertEquals(joueurNamedTest.getRenfortsAPlacer(),VALUE0+VALUE10);
    }

    @Test
    public void testAjouterRenfortsDontAddValueWithNegativeInteger() throws ExceptionNegativeRenforts {
        assertThrows(ExceptionNegativeRenforts.class,()->{
            joueurNamedTest.ajouterRenforts(VALUEMINUS10);
        });
    }

    //attribuerMission
    @Test
    public void testAttribuerMissionAddMissionToJoueur(){
        joueurNamedTest.attribuerMission(missionEliminationRouge);
        assertEquals(joueurNamedTest.getMission(),missionEliminationRouge);
    }

    //attribuerCouleur
    @Test
    public void testAttribuerCouleurAddCouleurToJoueur(){
        joueurNamedTest.attribuerCouleur(colorNoir);
        assertEquals(joueurNamedTest.getCouleur(),colorNoir);
    }


    //ajouterTerritoire
    @Test
    public void testAjouterTerritoireChangePossesseurIfTerritoireHasNoPossesseur() throws ExceptionTerritoireStillHavePossesseur {
        joueurNamedTest.ajouterTerritoire(territoireNamedTest);
        assertEquals(territoireNamedTest.getPossesseur(),joueurNamedTest);
    }

    @Test
    public void testAjouterTerritoireAddTerritoireIfTerritoireHasNoPossesseur() throws ExceptionTerritoireStillHavePossesseur {
        joueurNamedTest.ajouterTerritoire(territoireNamedTest);
        assertEquals(joueurNamedTest.getTerritoiresPossedes().size(),1);
    }


    @Test
    public void testAjouterTerritoireDontAddTerritoireIfTerritoireHasPossesseur() throws ExceptionTerritoireStillHavePossesseur {
        joueurNamedTest.ajouterTerritoire(territoireNamedTest);
        assertEquals(territoireNamedTest.getPossesseur(),joueurNamedTest);
    }

    @Test
    public void testAjouterTerritoireThrowsExceptionTerritoireStillHavePossesseurIfTerritoireStillHavePossesseur() throws ExceptionTerritoireStillHavePossesseur {
        joueurNamedOther.ajouterTerritoire(territoireNamedTest);
        assertThrows(ExceptionTerritoireStillHavePossesseur.class,()->{
            joueurNamedTest.ajouterTerritoire(territoireNamedTest);
        });
    }

}
