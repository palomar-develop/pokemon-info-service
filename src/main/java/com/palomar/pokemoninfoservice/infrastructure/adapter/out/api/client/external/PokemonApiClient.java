package com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.external;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;

public interface PokemonApiClient {
    PokemonResponse getPokemonByName(String name);
}