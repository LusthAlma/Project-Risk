package fr.alma.risk.jpaclasses.accessingdatamysql;

import fr.alma.risk.datatypes.mission.Mission;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MissionRepository extends CrudRepository<Mission, Integer> {

}