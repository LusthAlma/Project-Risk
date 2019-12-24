package fr.alma.risk.datatypes;

import fr.alma.risk.datatypes.map.Territoire;

import java.util.Set;

public class Plateau {
    private Set<Territoire> carte;

    public Plateau(Set<Territoire> carte) {
        this.carte = carte;
    }
}
