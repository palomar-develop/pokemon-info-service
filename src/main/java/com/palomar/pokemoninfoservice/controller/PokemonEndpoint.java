package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.model.dto.AbilitiesRequest;
import com.palomar.pokemoninfoservice.model.dto.AbilitiesResponse;
import com.palomar.pokemoninfoservice.model.dto.TextRequest;
import com.palomar.pokemoninfoservice.model.dto.TextResponse;
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
    public AbilitiesResponse handleText(@RequestPayload AbilitiesRequest request) {
        AbilitiesResponse response = new AbilitiesResponse();
        PokemonResponse pokemon = pokeApiService.getPokemonByName(request.getPokemonName());
        response.setAbilities(pokemon.getAbilities());
        //response.setPokemonName("Recibido: " + request.getPokemonName());
        return response;
    }
}
