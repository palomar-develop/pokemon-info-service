package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.model.dto.*;
import com.palomar.pokemoninfoservice.service.PokemonSoapService;
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
public class PokemonSoapController {

    private final PokemonSoapService pokemonSOAPService;


    @Autowired
    public PokemonSoapController(PokemonSoapService pokemonApiService) {
        this.pokemonSOAPService = pokemonApiService;
    }

    private static final String NAMESPACE_URI = "http://pokemon.com/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AbilitiesRequest")
    @ResponsePayload
    public AbilitiesResponse handleAbilities(@RequestPayload AbilitiesRequest request) {
        return  pokemonSOAPService.getAbilities(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BaseExperienceRequest")
    @ResponsePayload
    public BaseExperienceResponse handleBaseExperience(@RequestPayload BaseExperienceRequest request) {
        return pokemonSOAPService.getBaseExperience(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HeldItemRequest")
    @ResponsePayload
    public HeldItemResponse handleHeldItem(@RequestPayload HeldItemRequest request) {
    return pokemonSOAPService.getHeldItem(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocationAreaEncountersRequest")
    @ResponsePayload
    public LocationAreaEncountersResponse handleLocationAreaEncounters(@RequestPayload LocationAreaEncountersRequest request) {
        return pokemonSOAPService.getLocationAreaEncounters(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NameRequest")
    @ResponsePayload
    public NameResponse handleName(@RequestPayload NameRequest request) {
        return  pokemonSOAPService.getName(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IdRequest")
    @ResponsePayload
    public IdResponse handleId(@RequestPayload IdRequest request) {
        return  pokemonSOAPService.getId(request);
    }


}
