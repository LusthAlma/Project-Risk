package fr.alma.risk.jpaclasses.accessingdatamysql;

import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.mission.MissionElimination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ContinentRepository extends CrudRepository<Continent, Integer> {

    /**
     * Requête permettant d'obtenir un continent en passant son nom en paramètre
     * @param nom du continent a retrouver
     * @return renvoit le continent avec le nom en question.
     */
    @Query(value = "SELECT * FROM continents WHERE nom = :continentname",nativeQuery = true)
    public List<MissionElimination> findMissionElimination(@Param("continentname") String nom);

    /**
     * Requête permettant de retrouver le continent qui contient le pays passé en paramètre
     * @param nom du pays dont on veut trouver le continent
     * @return renvoit le continent en question
     */
    @Query(value = "SELECT id,nom,renforts_bonus FROM (SELECT continent_id FROM territoires WHERE nom = :territoryname) AS t2  INNER JOIN continents ON continents.id = t2.continent_id",nativeQuery = true)
    public Continent findContinentOfTerritory(@Param("territoryname") String nom);

    /**
     * Requête permettant de retrouver le continent qui contient le pays passé en paramètre
     * @param id du pays dont on veut trouver le continent
     * @return renvoit le continent en question
     */
    @Query(value = "SELECT id,nom,renforts_bonus FROM (SELECT continent_id FROM territoires WHERE id = :territoryid) AS t2  INNER JOIN continents ON continents.id = t2.continent_id",nativeQuery = true)
    public Continent findContinentOfTerritory(@Param("territoryid") long id);
}