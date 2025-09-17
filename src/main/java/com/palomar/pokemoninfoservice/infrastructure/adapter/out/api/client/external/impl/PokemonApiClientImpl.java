package com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.external.impl;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.infrastructure.config.PokemonApiProperties;
import com.palomar.pokemoninfoservice.infrastructure.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.infrastructure.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Component
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
            return restTemplate.getForObject(url, PokemonResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFoundException(Constants.POKEMON_NOT_FOUND_MESSAGE + name);
        }
    }
}
