package fr.alma.risk.jpaclasses.accessingdatamysql;

import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TerritoireRepository extends CrudRepository<Territoire, Integer> {

    /**
     * Requête permettant de retrouver le territoire avec l'id en paramètre
     * @param id du territoire que l'on veut trouver
     * @return renvoit le territoire en question
     */
    @Query(value = "SELECT * FROM territoires WHERE id = :paramid",nativeQuery = true)
    public Territoire findWithId(@Param("paramid") Long id);

    /**
     * Requête permettant de retrouver le territoire avec le nom en paramètre
     * @param name du territoire que l'on veut trouver
     * @return renvoit le territoire en question
     */
    @Query(value = "SELECT * FROM territoires WHERE nom = :territoryname",nativeQuery = true)
    public Territoire findWithNom(@Param("territoryname") String name);

    /**
     * Requête permettant de trouver tous les voisins d'un pays en donnant son nom.
     * @param nom du pays dont on cherche les voisins
     * @return renvoit la liste des pays étant de le voisin de celui passe en parametre
     */
    @Query(value = "SELECT id,nom,continent_id FROM (SELECT voisin_id FROM (SELECT * FROM territoires WHERE nom = :territoryname) AS t2 INNER JOIN voisins ON t2.id = voisins.territoire_id) AS t3 INNER JOIN territoires ON t3.voisin_id = territoires.id ",nativeQuery = true)
    public List<Territoire> findVoisins(@Param("territoryname") String nom);

    /**
     * Requête permettant de trouver tous les voisins d'un pays en donnant son id.
     * @param id du pays dont on cherche les voisins
     * @return renvoit la liste des pays étant de le voisin de celui passe en parametre
     */
    @Query(value = "SELECT id,nom,continent_id FROM (SELECT voisin_id FROM (SELECT * FROM territoires WHERE id = :territoryid) AS t2 INNER JOIN voisins ON t2.id = voisins.territoire_id) AS t3 INNER JOIN territoires ON t3.voisin_id = territoires.id ",nativeQuery = true)
    public List<Territoire> findVoisins(@Param("territoryid") Long id);

    /**
     * Requête permettant de savoir le nombre de territoire
     * @return renvoit le nombre de territoires
     */
    @Query(value = "SELECT COUNT(*) FROM territoires",nativeQuery = true)
    public int nbTerritoire();


}