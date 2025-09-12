package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.client.external.PokeApiClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeApiService {
    private final PokeApiClient pokeApiClient;

    @Autowired
    public PokeApiService(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    public PokemonResponse getPokemonByName(String name) {
        return pokeApiClient.getPokemonByName(name);
    }
}
