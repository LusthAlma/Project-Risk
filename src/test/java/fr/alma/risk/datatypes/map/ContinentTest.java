package fr.alma.risk.datatypes.map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import  org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class ContinentTest {

    private Continent continentNamedTestInitialisedWith0Territoires;
    private Set<Territoire> territoireSetWith3Territoires;
    Territoire territoireNamedTest1;
    Territoire territoireNamedTest2;
    Territoire territoireNamedTest3;
    private final int NBRENFORTBONUSEQUAL5 = 5;


    @Before
    public void setup(){
        continentNamedTestInitialisedWith0Territoires = new Continent("Test",NBRENFORTBONUSEQUAL5);
        territoireNamedTest1 = Mockito.mock(Territoire.class);
        territoireNamedTest2 = Mockito.mock(Territoire.class);
        territoireNamedTest3 = Mockito.mock(Territoire.class);
        territoireSetWith3Territoires = new HashSet<>();
        territoireSetWith3Territoires.add(territoireNamedTest1);
        territoireSetWith3Territoires.add(territoireNamedTest2);
        territoireSetWith3Territoires.add(territoireNamedTest3);
    }


    @Test
    public void testContainsTerritoireReturnTrueWhenSetOfTerritoireContainsTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        assertTrue(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
    }

    @Test
    public void testContainsTerritoireReturnFalseWhenSetOfTerritoireDoesNotContainsTerritoire(){
        assertFalse(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
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

    @Test
    public void testAddTerritoireAddTerritoireToSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        assertTrue(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
    }

    @Test
    public void testAddTerritoireReturnTrueWhenSetOfTerritoireAddedWasntInSetOfTerritoire(){
        assertTrue(continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireSetWith3Territoires));
    }

    @Test
    public void testAddTerritoireReturnFalseWhenSetOfTerritoireAddedWasInSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest2);
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest3);
        assertFalse(continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireSetWith3Territoires));
    }

    @Test
    public void testAddTerritoireAddSetOfTerritoireToSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireSetWith3Territoires);
        assertTrue(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
        assertTrue(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest2));
        assertTrue(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest3));
    }

    @Test
    public void testRemoveTerritoireReturnTrueIfTerritoireIsRemovedFromSet(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        assertTrue(continentNamedTestInitialisedWith0Territoires.removeTerritoire(territoireNamedTest1));
    }

    @Test
    public void testRemoveTerritoireReturnFalseIfTerritoireIsNotInSet(){
        assertFalse(continentNamedTestInitialisedWith0Territoires.removeTerritoire(territoireNamedTest1));
    }

    @Test
    public void testRemoveTerritoireRemoveTerritoireFromSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireNamedTest1);
        continentNamedTestInitialisedWith0Territoires.removeTerritoire(territoireNamedTest1);
        assertFalse(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
    }

    @Test
    public void testRemoveTerritoireRemoveSetOfTerritoireFromSetOfTerritoire(){
        continentNamedTestInitialisedWith0Territoires.addTerritoire(territoireSetWith3Territoires);
        continentNamedTestInitialisedWith0Territoires.removeTerritoire(territoireSetWith3Territoires);
        assertFalse(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest1));
        assertFalse(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest2));
        assertFalse(continentNamedTestInitialisedWith0Territoires.containsTerritoire(territoireNamedTest3));
    }

}
