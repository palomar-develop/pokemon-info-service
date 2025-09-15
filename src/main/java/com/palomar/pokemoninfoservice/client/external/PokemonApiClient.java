package com.palomar.pokemoninfoservice.client.external;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.config.PokemonApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.utils.Constants;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Component
public class PokemonApiClient {
    private final RestTemplate restTemplate;
    private final PokemonApiProperties pokemonApiProperties;

    @Autowired
    public PokemonApiClient(RestTemplate restTemplate, PokemonApiProperties pokemonApiProperties) {
        this.restTemplate = restTemplate;
        this.pokemonApiProperties = pokemonApiProperties;
    }

    public PokemonResponse getPokemonByName(String name) {
        String url = pokemonApiProperties.getBaseUrl()  + name;
        try {
            return restTemplate.getForObject(url, PokemonResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFoundException(Constants.POKEMON_NOT_FOUND_MESSAGE + name);
        }
    }
}
