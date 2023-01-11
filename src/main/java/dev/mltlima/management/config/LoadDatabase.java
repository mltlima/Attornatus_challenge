package dev.mltlima.management.config;

import dev.mltlima.management.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

import dev.mltlima.management.model.User;
import dev.mltlima.management.repository.UserRepository;
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    Address testAddress = new Address("Rua 1", "1", "apt 1", "Bairro 1", "Cidade 1", "Estado 1", "Pais 1", "11111111");
    /*
    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading" + repository.save(new User("Fulano", "fulano@mail.com", "01/01/2000", testList))));
            log.info("Preloading" + repository.save(new User("Beltrano", "beltrano@mail.com", "01/01/1990")));
        };
    }*/
}