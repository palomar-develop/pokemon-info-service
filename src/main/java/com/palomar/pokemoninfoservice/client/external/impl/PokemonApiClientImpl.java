package com.palomar.pokemoninfoservice.client.external.impl;

import com.palomar.pokemoninfoservice.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.config.PokemonApiProperties;
import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Component
@Qualifier("default")
@Log4j2
public class PokemonApiClientImpl implements PokemonApiClient {
    private final RestTemplate restTemplate;
    private final PokemonApiProperties pokemonApiProperties;

    @Autowired
    public PokemonApiClientImpl(RestTemplate restTemplate, PokemonApiProperties pokemonApiProperties) {
        this.restTemplate = restTemplate;
        this.pokemonApiProperties = pokemonApiProperties;
    }
    /**
     * Llama a la API externa para obtener la información del Pokémon por nombre.
     *
     * @param name El nombre del Pokémon.
     * @return La respuesta con la información del Pokémon.
     * @throws PokemonNotFoundException Si el Pokémon no es encontrado.
     */
    @Override
    public PokemonResponse getPokemonByName(String name) {
        String url = pokemonApiProperties.getBaseUrl()  + name;
        try {
            log.info("REST Fetching Pokémon data for name: {}", name);
            return restTemplate.getForObject(url, PokemonResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFoundException(Constants.POKEMON_NOT_FOUND_MESSAGE + name);
        }
    }
}
