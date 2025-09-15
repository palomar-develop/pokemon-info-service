package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;

/**
 * Autor: josue.palomar
 * Fecha de creación: 15/09/25
 */
public interface PokemonApiService {
    public PokemonResponse getPokemonByName(String name);
}
