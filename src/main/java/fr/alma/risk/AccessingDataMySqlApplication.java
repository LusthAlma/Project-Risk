package fr.alma.risk;

import fr.alma.risk.accessingdatamysql.ContinentRepository;
import fr.alma.risk.accessingdatamysql.MissionRepository;
import fr.alma.risk.accessingdatamysql.TerritoireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataMySqlApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataMySqlApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMySqlApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(MissionRepository missionRepository, TerritoireRepository territoireRepository, ContinentRepository continentRepository) {
        return (args) -> {
            //example
            missionRepository.save(new MissionConqueteTerritoire(12));
            territoireRepository.save(new Territoire("Japon"));
            continentRepository.save(new Continent("Afrique",8));
            log.info("");
        };
    }

}