package com.palomar.pokemoninfoservice.service.impl;

import com.palomar.pokemoninfoservice.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonApiServiceImpl implements PokemonApiService {
    private final PokemonApiClient pokeApiClient;

    @Autowired
    public PokemonApiServiceImpl(PokemonApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }
    @Override
    public PokemonResponse getPokemonByName(String name) {
        return pokeApiClient.getPokemonByName(name);
    }
}
