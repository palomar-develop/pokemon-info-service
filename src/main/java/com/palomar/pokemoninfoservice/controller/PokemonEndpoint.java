package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.model.dto.AbilitiesRequest;
import com.palomar.pokemoninfoservice.model.dto.AbilitiesResponse;
import com.palomar.pokemoninfoservice.model.dto.BaseExperienceRequest;
import com.palomar.pokemoninfoservice.model.dto.BaseExperienceResponse;
import com.palomar.pokemoninfoservice.model.dto.TextRequest;
import com.palomar.pokemoninfoservice.model.dto.TextResponse;
import com.palomar.pokemoninfoservice.model.dto.HeldItemRequest;
import com.palomar.pokemoninfoservice.model.dto.HeldItemResponse;
import com.palomar.pokemoninfoservice.model.dto.LocationAreaEncountersRequest;
import com.palomar.pokemoninfoservice.model.dto.LocationAreaEncountersResponse;
import com.palomar.pokemoninfoservice.model.dto.NameRequest;
import com.palomar.pokemoninfoservice.model.dto.NameResponse;
import com.palomar.pokemoninfoservice.model.dto.IdRequest;
import com.palomar.pokemoninfoservice.model.dto.IdResponse;
import com.palomar.pokemoninfoservice.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Endpoint
public class PokemonEndpoint {

    private final PokeApiService pokeApiService;

    @Autowired
    public PokemonEndpoint(PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    private static final String NAMESPACE_URI = "http://pokemon.com/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AbilitiesRequest")
    @ResponsePayload
    public AbilitiesResponse handleAbilities(@RequestPayload AbilitiesRequest request) {
        AbilitiesResponse response = new AbilitiesResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setAbilities(pokemon.getAbilities());
        //response.setPokemonName("Recibido: " + request.getPokemonName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BaseExperienceRequest")
    @ResponsePayload
    public BaseExperienceResponse handleBaseExperience(@RequestPayload BaseExperienceRequest request) {
        BaseExperienceResponse response = new BaseExperienceResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setBaseExperience(pokemon.getBaseExperience());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HeldItemRequest")
    @ResponsePayload
    public HeldItemResponse handleHeldItem(@RequestPayload HeldItemRequest request) {
        HeldItemResponse response = new HeldItemResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setHeldItem(pokemon.getHeldItems());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocationAreaEncountersRequest")
    @ResponsePayload
    public LocationAreaEncountersResponse handleLocationAreaEncounters(@RequestPayload LocationAreaEncountersRequest request) {
        LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NameRequest")
    @ResponsePayload
    public NameResponse handleName(@RequestPayload NameRequest request) {
        NameResponse response = new NameResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setName(pokemon.getName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IdRequest")
    @ResponsePayload
    public IdResponse handleId(@RequestPayload IdRequest request) {
        IdResponse response = new IdResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setId(pokemon.getId());
        return response;
    }


}
