package fr.alma.risk.jpaclasses.accessingdatamysql;

import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.mission.MissionConqueteContinent;
import fr.alma.risk.datatypes.mission.MissionConqueteTerritoire;
import fr.alma.risk.datatypes.mission.MissionElimination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MissionRepository extends CrudRepository<Mission, Integer> {

    /**
     * Requête permettant de retrouver toutes les missions du type MissionElimination
     * @return renvoit les missions du types MissionElimination
     */
    @Query(value = "SELECT * FROM missions WHERE dtype = 'MissionElimination'",nativeQuery = true)
    public List<MissionElimination> findMissionElimination();

    /**
     * Requête permettant de retrouver toutes les missions du type MissionConqueteContinent
     * @return renvoit les missions du types MissionConqueteContinent
     */
    @Query(value = "SELECT * FROM missions WHERE dtype = 'MissionConqueteContinent'",nativeQuery = true)
    public List<MissionConqueteContinent> findMissionConqueteContinent();

    /**
     * Requête permettant de retrouver toutes les missions du type MissionConqueteTerritoire
     * @return renvoit les missions du types MissionConqueteTerritoire
     */
    @Query(value = "SELECT * FROM missions WHERE dtype = 'MissionConqueteTerritoire'",nativeQuery = true)
    public List<MissionConqueteTerritoire> findMissionConqueteTerritoire();

    /**
     * Requête permettant de savoir le nombre de missions
     * @return renvoit le nombre de mission.
     */
    @Query(value = "SELECT * FROM missions WHERE id = :missionid",nativeQuery = true)
    public Mission findMissionById(@Param("missionid") long id);

    /**
     * Requête permettant de retrouver le nombre de missions dans le repository
     * @return le nombre de mission
     */
    @Query(value = "SELECT COUNT(*) FROM missions",nativeQuery = true)
    public Integer nbMission();
}