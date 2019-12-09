package fr.alma.risk.accessingdatamysql;

import fr.alma.risk.Continent;
import fr.alma.risk.Mission;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ContinentRepository extends CrudRepository<Continent, Integer> {

}