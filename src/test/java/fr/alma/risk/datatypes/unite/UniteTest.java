package fr.alma.risk.datatypes.unite;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fr.alma.risk.datatypes.player.Joueur;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.exception.ExceptionRisk;
import fr.alma.risk.exception.ExceptionTerritoryCantBeEmpty;
import fr.alma.risk.exception.ExceptionUniteHasNoTerritory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UniteTest {

    private Joueur joueurMock;
    private Unite uniteSimpleWithJoueurNamedTest1;
    private Unite uniteSimpleWithJoueurNamedTest2;
    private Territoire territoirMockDepart;
    private Territoire territoireMockArriver;

    @Before
    public void setup(){
        joueurMock = Mockito.mock(Joueur.class);
        uniteSimpleWithJoueurNamedTest1 = new UniteSimple(joueurMock);
        uniteSimpleWithJoueurNamedTest2 = new UniteSimple(joueurMock);

        territoirMockDepart = Mockito.mock(Territoire.class);
        territoireMockArriver = Mockito.mock(Territoire.class);

    }

    @Test
    public void testPlacerChangeSetTerritory(){
        uniteSimpleWithJoueurNamedTest1.placer(territoirMockDepart);
        assertEquals(uniteSimpleWithJoueurNamedTest1.getTerritoire(), territoirMockDepart);
    }

    @Test
    public void testPlacerAddUniteToTerritorySetofUnite(){
        uniteSimpleWithJoueurNamedTest1.placer(territoirMockDepart);
        assertTrue(territoirMockDepart.getUnitesDeployees().contains(uniteSimpleWithJoueurNamedTest1));

    }

    @Test
    public void testDeplacerChangeTerritoireIfPreviousTerritoireNotEmpty() throws ExceptionRisk {
        uniteSimpleWithJoueurNamedTest1.placer(territoirMockDepart);
        uniteSimpleWithJoueurNamedTest2.placer(territoirMockDepart);
        uniteSimpleWithJoueurNamedTest1.deplacer(territoireMockArriver);
        assertEquals(uniteSimpleWithJoueurNamedTest1.getTerritoire(), territoireMockArriver);
    }

    @Test
    public void testDeplacerThrowsExceptionUniteHasNotTerritoryIfUniteHasNoTerritory(){
        assertThrows(ExceptionUniteHasNoTerritory.class,()->{
           uniteSimpleWithJoueurNamedTest1.deplacer(territoireMockArriver);
        });
    }

    @Test
    public void testDeplacerThrowsExceptionTerritoryCantBeEmptyIfTerritoryFromStartBecomeEmptyWithoutUnite(){
        uniteSimpleWithJoueurNamedTest1.placer(territoirMockDepart);
        assertThrows(ExceptionTerritoryCantBeEmpty.class,()->{
            uniteSimpleWithJoueurNamedTest1.deplacer(territoireMockArriver);
        });
    }

}
