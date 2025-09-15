package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.model.dto.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 15/09/25
 */
public interface PokemonSoapService {
    AbilitiesResponse getAbilities(AbilitiesRequest request);
    BaseExperienceResponse getBaseExperience(BaseExperienceRequest request);
    HeldItemResponse getHeldItem(HeldItemRequest request);
    LocationAreaEncountersResponse getLocationAreaEncounters(LocationAreaEncountersRequest request);
    NameResponse getName(NameRequest request);
    IdResponse getId(IdRequest request);
}
