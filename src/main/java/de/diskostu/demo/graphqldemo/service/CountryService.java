package de.diskostu.demo.graphqldemo.service;

import de.diskostu.demo.graphqldemo.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient graphQlClient;


    public CountryService() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();

        graphQlClient = HttpGraphQlClient.builder(client).build();
    }


    public Mono<List<Country>> getCountries() {
        //language=GraphQL
        final String document = """
                query {
                    countries {
                        name
                        emoji
                        currency
                        code
                        capital
                    }
                }

                """;

        return graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);
    }
}
