import java.util.Set;

public class Continent {
    private String nom;
    private int renfortsBonus;
    private Set<Territoire> territoires;

    public Continent(String nom, int renfortsBonus, Set<Territoire> territoires) {
        this.nom = nom;
        this.renfortsBonus = renfortsBonus;
        this.territoires = territoires;
    }
}
