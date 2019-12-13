package fr.alma.risk.jpaclasses.accessingdatamysql;

import fr.alma.risk.datatypes.map.Territoire;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TerritoireRepository extends CrudRepository<Territoire, Integer> {

}