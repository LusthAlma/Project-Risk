import java.util.Set;

public class Territoire {

    private String nom;
    private Joueur possesseur;
    private Set<Unité> unitésDéployées;
    private Set<Territoire> voisins;

    public Territoire(String nom, Set<Territoire> voisins) {
        this.nom =  nom;
        this.voisins = voisins;
    }
}
