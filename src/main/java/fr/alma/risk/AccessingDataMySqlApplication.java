package fr.alma.risk;

import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.jpaclasses.accessingdatamysql.ContinentRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.MissionRepository;
import fr.alma.risk.jpaclasses.accessingdatamysql.TerritoireRepository;
import fr.alma.risk.datageneration.DataGeneration;
import fr.alma.risk.datageneration.GeneratedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class AccessingDataMySqlApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataMySqlApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMySqlApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner demo(MissionRepository missionRepository, TerritoireRepository territoireRepository, ContinentRepository continentRepository) {
        return (args) -> {

            //Cette partie de code sert a générer les données de base du risk ( Continent, Territoire, Mission).
            GeneratedData datas = DataGeneration.generate();
            Set<Continent> continents = datas.getContinents();
            Set<Territoire> territoires = datas.getTerritoires();
            Set<Mission> missions = datas.getMissions();

            missionRepository.saveAll(missions);
            continentRepository.saveAll(continents);
            territoireRepository.saveAll(territoires);


            //Show the content of the 3 repository as example.
            log.info("");
            log.info("continentRepository.findall");
            for (Continent continent : continentRepository.findAll()) {
                log.info("continent "+ continent.getNom() + " avec renfort :" +continent.getRenfortsBonus());
            }
            log.info("");
            log.info("territoireRepository.findall");
            for (Territoire territoire : territoireRepository.findAll()) {
                log.info("territoire "+ territoire.getNom());
            }
            log.info("");
            log.info("missionRepository.findall");
            for (Mission mission : missionRepository.findAll()) {
                log.info("territoire "+ mission.getObjectif());
            }
            log.info("");

            // fetch territoire by id
            log.info("Territoire found with findByNom('1'):");
            log.info("--------------------------------------------");
            log.info(territoireRepository.findWithId((long)1).getNom());
            log.info("");

            // fetch territoire by nom
            log.info("Territoire found with findByNom('Chine'):");
            log.info("--------------------------------------------");
            log.info(territoireRepository.findWithNom("Chine").getNom());
            log.info("");

            //fetch voisins
            log.info("Territoire found with findVoisinsWithNom('Chine'):");
            log.info("--------------------------------------------");
            territoireRepository.findVoisins("Chine").forEach(voisin -> {
                log.info(voisin.getNom());
            });
            log.info("");

            //fetch continent
            log.info("Territoire found with findContinentWithName('Chine'):");
            log.info("--------------------------------------------");
            log.info(continentRepository.findContinentOfTerritory("Chine").getNom());
            log.info("");


            //fetch mission elimination
            log.info("Mission found with findMissionElimination():");
            log.info("--------------------------------------------");
            missionRepository.findMissionElimination().forEach(missionElimination -> {
                log.info(missionElimination.getObjectif());
            });
            log.info("");

            //fetch mission elimination
            log.info("Mission found with findMissionConqueteContinent():");
            log.info("--------------------------------------------");
            missionRepository.findMissionConqueteContinent().forEach(missionConqueteContinent -> {
                log.info(missionConqueteContinent.getObjectif());
            });
            log.info("");

            //fetch mission elimination
            log.info("Mission found with findMissionConqueteTerritoire():");
            log.info("--------------------------------------------");
            missionRepository.findMissionConqueteTerritoire().forEach(missionConqueteTerritoire -> {
                log.info(missionConqueteTerritoire.getObjectif());
            });


            log.info(missionRepository.nbMission()+" missions");

            log.info(territoireRepository.nbTerritoire()+" territoires");
        };
    }
*/
}