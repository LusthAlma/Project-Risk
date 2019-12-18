package fr.alma.risk.datatypes.map;

import static org.junit.Assert.*;

import fr.alma.risk.datatypes.map.Territoire;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ContinentTest {

    private Continent continentNamedTestInitialisedWith0Territoires;
    private Continent continentNamedOtherInitialiseWith3Territoires;
    private Set<Territoire> territoireSetWith3Territoires;
    private final int NBRENFORTBONUSEQUAL5 = 5;


    @Before
    public void setup(){
        continentNamedTestInitialisedWith0Territoires = new Continent("Test",NBRENFORTBONUSEQUAL5);
    }



}
