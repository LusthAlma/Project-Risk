package fr.alma.risk;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TerritoireTest {

    private Territoire territoireNamedTest;
    private Territoire territoireNamedOther;

    @Before
    public void setup(){
        territoireNamedTest = new Territoire("Test");
        territoireNamedOther = new Territoire("Other");
    }

    @Test
    public void testAjoutVoisinReturnTrueWhenTerritoireBecomeVoisin(){
        assertTrue(territoireNamedTest.ajoutVoisin(territoireNamedOther));
    }

    @Test
    public void testAjoutVoisinReturnFalseWhenVoisinIsSameObject(){
        assertFalse(territoireNamedTest.ajoutVoisin(territoireNamedTest));
    }


    @Test
    public void testAjoutVoisinAddTerritoireToVoisins(){
        territoireNamedTest.ajoutVoisin(territoireNamedOther);
        assertTrue(territoireNamedTest.getVoisins().contains(territoireNamedOther));
    }

    @Test
    public void testAjoutVoisinDontAddItselftToVoisins(){
        territoireNamedTest.ajoutVoisin(territoireNamedTest);
        assertFalse(territoireNamedTest.getVoisins().contains(territoireNamedTest));
    }

    @Test
    public void testAjoutVoisinReturnFalseWhenAddTwoTimeSameObject(){
        territoireNamedTest.ajoutVoisin(territoireNamedOther);
        assertFalse(territoireNamedTest.ajoutVoisin(territoireNamedOther));
    }

}
