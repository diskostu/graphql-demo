package de.diskostu.demo.graphqldemo;

import de.diskostu.demo.graphqldemo.model.Country;
import de.diskostu.demo.graphqldemo.repository.CountryRepository;
import de.diskostu.demo.graphqldemo.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository) {
        return args -> {
            final Mono<List<Country>> countries = service.getCountries();
            countries.subscribe(repository::saveAll);
        };
    }
}
