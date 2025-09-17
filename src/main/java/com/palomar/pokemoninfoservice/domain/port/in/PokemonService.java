package com.palomar.pokemoninfoservice.domain.port.in;
import com.palomar.pokemoninfoservice.domain.model.dto.BaseExperienceResponse;
import com.palomar.pokemoninfoservice.domain.model.dto.HeldItemResponse;
import com.palomar.pokemoninfoservice.domain.model.dto.LocationAreaEncountersResponse;
import com.palomar.pokemoninfoservice.domain.model.dto.AbilitiesResponse;
import com.palomar.pokemoninfoservice.domain.model.dto.NameResponse;
import com.palomar.pokemoninfoservice.domain.model.dto.IdResponse;

public interface PokemonService {
    AbilitiesResponse getAbilities(String pokemonName);
    BaseExperienceResponse getBaseExperience(String pokemonName);
    HeldItemResponse getHeldItem(String pokemonName);
    LocationAreaEncountersResponse getLocationAreaEncounters(String pokemonName);
    NameResponse getName(String pokemonName);
    IdResponse getId(String pokemonName);
}