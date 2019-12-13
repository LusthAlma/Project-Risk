package fr.alma.risk.datageneration;

import fr.alma.risk.datatypes.Continent;
import fr.alma.risk.datatypes.Mission;
import fr.alma.risk.datatypes.Territoire;

import java.util.Set;

public class GeneratedData {

    private Set<Continent> continents;
    private Set<Territoire> territoires;
    private Set<Mission> missions;

    public GeneratedData(Set<Continent> continentIterable,Set<Territoire> territoireIterable,Set<Mission> missionIterable){
        this.continents = continentIterable;
        this.territoires = territoireIterable;
        this.missions = missionIterable;
    }

    public Set<Continent> getContinents() {
        return continents;
    }

    public Set<Territoire> getTerritoires() {
        return territoires;
    }

    public Set<Mission> getMissions() {
        return missions;
    }
}
