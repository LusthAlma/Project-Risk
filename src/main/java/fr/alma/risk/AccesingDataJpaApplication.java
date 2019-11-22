package fr.alma.risk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AccesingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccesingDataJpaApplication.class);

    public static void main(String[] args){
        SpringApplication.run(AccesingDataJpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(MissionRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new MissionConqueteTerritoire("Test",5));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Mission customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Mission mission = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(mission.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByObjectif('Test'):");
            log.info("--------------------------------------------");
            repository.findByObjectif("Test").forEach(test -> {
                log.info(test.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
