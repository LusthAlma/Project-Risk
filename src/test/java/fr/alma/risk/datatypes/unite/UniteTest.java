package fr.alma.risk.datatypes.unite;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.unite.Unite;
import fr.alma.risk.datatypes.unite.UniteSimple;
import fr.alma.risk.exception.ExceptionRisk;
import fr.alma.risk.exception.ExceptionTerritoryCantBeEmpty;
import fr.alma.risk.exception.ExceptionUniteHasNoTerritory;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;


public class UniteTest {

    private Joueur joueurNamedTest;
    private Unite uniteSimpleWithJoueurNamedTest1;
    private Unite uniteSimpleWithJoueurNamedTest2;
    private Territoire testTerritoireNamedPlacer;
    private Territoire testTerritoireNamedArriver;

    @Before
    public void setup(){
        joueurNamedTest = new Joueur("Test", Color.black,"12345");
        uniteSimpleWithJoueurNamedTest1 = new UniteSimple(joueurNamedTest);
        uniteSimpleWithJoueurNamedTest2 = new UniteSimple(joueurNamedTest);

        testTerritoireNamedPlacer = new Territoire("Placer");
        testTerritoireNamedArriver = new Territoire("Arriver");
    }

    @Test
    public void testPlacerChangeSetTerritory(){
        uniteSimpleWithJoueurNamedTest1.placer(testTerritoireNamedPlacer);
        assertEquals(uniteSimpleWithJoueurNamedTest1.getTerritoire(),testTerritoireNamedPlacer);
    }

    @Test
    public void testPlacerAddUniteToTerritorySetofUnite(){
        uniteSimpleWithJoueurNamedTest1.placer(testTerritoireNamedPlacer);
        assertTrue(testTerritoireNamedPlacer.getUnitesDeployees().contains(uniteSimpleWithJoueurNamedTest1));

    }

    @Test
    public void testDeplacerChangeTerritoireIfPreviousTerritoireNotEmpty() throws ExceptionRisk {
        uniteSimpleWithJoueurNamedTest1.placer(testTerritoireNamedPlacer);
        uniteSimpleWithJoueurNamedTest2.placer(testTerritoireNamedPlacer);
        uniteSimpleWithJoueurNamedTest1.deplacer(testTerritoireNamedArriver);
        assertEquals(uniteSimpleWithJoueurNamedTest1.getTerritoire(), testTerritoireNamedArriver);
    }

    @Test
    public void testDeplacerThrowsExceptionUniteHasNotTerritoryIfUniteHasNoTerritory(){
        assertThrows(ExceptionUniteHasNoTerritory.class,()->{
           uniteSimpleWithJoueurNamedTest1.deplacer(testTerritoireNamedArriver);
        });
    }

    @Test
    public void testDeplacerThrowsExceptionTerritoryCantBeEmptyIfTerritoryFromStartBecomeEmptyWithoutUnite(){
        uniteSimpleWithJoueurNamedTest1.placer(testTerritoireNamedPlacer);
        assertThrows(ExceptionTerritoryCantBeEmpty.class,()->{
            uniteSimpleWithJoueurNamedTest1.deplacer(testTerritoireNamedArriver);
        });
    }

}