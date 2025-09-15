package com.palomar.pokemoninfoservice.client.external;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;

public interface PokemonApiClient {
    PokemonResponse getPokemonByName(String name);
}