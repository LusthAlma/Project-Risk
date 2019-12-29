package fr.alma.risk.datatypes.map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ContinentTest {

    private Continent continentNamedTestInitialisedWith0Territoires;
    private Continent continentNamedOtherInitialiseWith3Territoires;
    private Set<Territoire> territoireSetWith3Territoires;
    Territoire territoireNamedTest1;
    Territoire territoireNamedTest2;
    Territoire territoireNamedTest3;
    private final int NBRENFORTBONUSEQUAL5 = 5;


    @Before
    public void setup(){
        continentNamedTestInitialisedWith0Territoires = new Continent("Test",NBRENFORTBONUSEQUAL5);
        territoireNamedTest1 = new Territoire("test1");
        territoireNamedTest2 = new Territoire("test2");
        territoireNamedTest3 = new Territoire("test3");
        territoireSetWith3Territoires = new HashSet<>();
        territoireSetWith3Territoires.add(territoireNamedTest1);
        territoireSetWith3Territoires.add(territoireNamedTest2);
        territoireSetWith3Territoires.add(territoireNamedTest3);
    }



    @Test
    public void testAddTerritoireReturnTrueWhenTerritoireAddedWasntInSetOfTerritoire(){

        assertTrue(continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1));
    }

    @Test
    public void testAddTerritoireReturnFalseWhenTerritoireAddedWasInSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        assertFalse(continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1));
    }

}
