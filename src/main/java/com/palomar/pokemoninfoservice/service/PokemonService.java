package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.model.dto.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 15/09/25
 */
public interface PokemonService {
    AbilitiesResponse getAbilities(String pokemonName);
    BaseExperienceResponse getBaseExperience(String pokemonName);
    HeldItemResponse getHeldItem(String pokemonName);
    LocationAreaEncountersResponse getLocationAreaEncounters(String pokemonName);
    NameResponse getName(String pokemonName);
    IdResponse getId(String pokemonName);
}
