package fr.alma.risk;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MissionRepository extends CrudRepository<Mission, Long> {

    List<Mission> findByObjectif(String objectif);

    Mission findById(long id);

}
