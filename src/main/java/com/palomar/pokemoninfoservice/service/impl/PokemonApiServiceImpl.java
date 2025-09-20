package com.palomar.pokemoninfoservice.service.impl;

import com.palomar.pokemoninfoservice.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PokemonApiServiceImpl implements PokemonApiService {
    private final PokemonApiClient pokeApiClient;

    @Autowired
    public PokemonApiServiceImpl(@Qualifier("feign") PokemonApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }
    /**
     * Llama al cliente para obtener la información del Pokémon por nombre.
     *
     * @param name El nombre del Pokémon.
     * @return La respuesta con la información del Pokémon.
     */
    @Override
    public PokemonResponse getPokemonByName(String name) {
        return pokeApiClient.getPokemonByName(name);
    }
}
