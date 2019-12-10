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

import java.util.HashSet;
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

            Territoire japon = new Territoire("Japon");
            Set<Territoire> territoiresAsie = new HashSet<>();
            territoiresAsie.add(japon);

            Continent asie = new Continent("Asie",7,territoiresAsie);
            japon.setContinent(asie);
            japon.setPossesseur(new Joueur("test"));
            //example
            missionRepository.save(new MissionConqueteTerritoire(12));
            continentRepository.save(asie);
            territoireRepository.save(japon);
            log.info("");
            log.info("contientRepository.findall");
            for (Continent continent : continentRepository.findAll()) {
                log.info("continent "+ continent.getNom() + " avec renfort :" +continent.getRenfortsBonus());
            }
            log.info("");
        };
    }

}