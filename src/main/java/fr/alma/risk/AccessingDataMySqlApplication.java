package fr.alma.risk;

import fr.alma.risk.accessingdatamysql.ContinentRepository;
import fr.alma.risk.accessingdatamysql.MissionRepository;
import fr.alma.risk.accessingdatamysql.TerritoireRepository;
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


    @Bean
    public CommandLineRunner demo(MissionRepository missionRepository, TerritoireRepository territoireRepository, ContinentRepository continentRepository) {
        return (args) -> {

            GeneratedData datas = DataGeneration.generate();
            Set<Continent> continents = datas.getContinents();
            Set<Territoire> territoires = datas.getTerritoires();
            Set<Mission> missions = datas.getMissions();

            missionRepository.saveAll(missions);
            continentRepository.saveAll(continents);
            territoireRepository.saveAll(territoires);


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
        };
    }

}