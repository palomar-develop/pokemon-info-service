package com.palomar.pokemoninfoservice.domain.port.out;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;

/**
 * Autor: josue.palomar
 * Fecha de creación: 15/09/25
 */
public interface PokemonApiService {
    PokemonResponse getPokemonByName(String name);
}
