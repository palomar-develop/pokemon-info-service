package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.model.entity.Bitacora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonApiService {
    private final PokemonApiClient pokeApiClient;

    @Autowired
    public PokemonApiService(PokemonApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    public PokemonResponse getPokemonByName(String name) {
        return pokeApiClient.getPokemonByName(name);
    }
}
