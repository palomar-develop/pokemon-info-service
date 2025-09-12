package com.palomar.pokemoninfoservice.client.external;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.config.PokeApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiClient {
    private final RestTemplate restTemplate;
    private final PokeApiProperties pokeApiProperties;

    @Autowired
    public PokeApiClient(RestTemplate restTemplate, PokeApiProperties pokeApiProperties) {
        this.restTemplate = restTemplate;
        this.pokeApiProperties = pokeApiProperties;
    }

    public PokemonResponse getPokemonByName(String name) {
        String url = pokeApiProperties.getBaseUrl() + "/pokemon/" + name;
        return restTemplate.getForObject(url, PokemonResponse.class);
    }
}
