package com.palomar.pokemoninfoservice.infrastructure.adapter.in.soap;

import com.palomar.pokemoninfoservice.domain.model.dto.*;

import com.palomar.pokemoninfoservice.domain.port.in.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Endpoint
public class PokemonSoapController {

    private final PokemonService pokemonService;


    @Autowired
    public PokemonSoapController(PokemonService pokemonApiService) {
        this.pokemonService = pokemonApiService;
    }

    private static final String NAMESPACE_URI = "http://pokemon.com/soap";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AbilitiesRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public AbilitiesResponse handleAbilities(@XPathParam("/po:AbilitiesRequest/po:pokemonName") String pokemonName) {
        return  pokemonService.getAbilities(pokemonName);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BaseExperienceRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public BaseExperienceResponse handleBaseExperience(@XPathParam("/po:BaseExperienceRequest/po:pokemonName") String pokemonName) {
        return pokemonService.getBaseExperience(pokemonName);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HeldItemRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public HeldItemResponse handleHeldItem(@XPathParam("/po:HeldItemRequest/po:pokemonName") String pokemonName) {
        return pokemonService.getHeldItem(pokemonName);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocationAreaEncountersRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public LocationAreaEncountersResponse handleLocationAreaEncounters(@XPathParam("/po:LocationAreaEncountersRequest/po:pokemonName") String pokemonName) {
        return pokemonService.getLocationAreaEncounters(pokemonName);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NameRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public NameResponse handleName(@XPathParam("/po:NameRequest/po:pokemonName") String pokemonName) {
        return  pokemonService.getName(pokemonName);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IdRequest")
    @Namespace(prefix="po",uri=NAMESPACE_URI)
    @ResponsePayload
    public IdResponse handleId(@XPathParam("/po:IdRequest/po:pokemonName") String pokemonName) {
        return  pokemonService.getId(pokemonName);
    }


}
