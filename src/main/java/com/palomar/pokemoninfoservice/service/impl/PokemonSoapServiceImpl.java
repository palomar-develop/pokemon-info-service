package com.palomar.pokemoninfoservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.model.dto.*;
import com.palomar.pokemoninfoservice.model.entity.Bitacora;
import com.palomar.pokemoninfoservice.service.BitacoraService;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import com.palomar.pokemoninfoservice.service.PokemonSoapService;
import com.palomar.pokemoninfoservice.utils.PokemonServiceConstants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@Service
@Slf4j
public class PokemonSoapServiceImpl implements PokemonSoapService {

    private final PokemonApiService pokemonApiService;
    private final BitacoraService bitacoraService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    public PokemonSoapServiceImpl(PokemonApiService pokemonApiService, BitacoraService bitacoraService) {
        this.pokemonApiService = pokemonApiService;
        this.bitacoraService = bitacoraService;
    }
    @Override
    public AbilitiesResponse getAbilities(AbilitiesRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_ABILITIES, request, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req.getPokemonName());
            AbilitiesResponse response = new AbilitiesResponse();
            response.setAbilities(pokemon.getAbilities());
            return response;
        });
    }
    @Override
    public BaseExperienceResponse getBaseExperience(BaseExperienceRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_BASE_EXPERIENCE, request, req -> {
            BaseExperienceResponse response = new BaseExperienceResponse();
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(request.getPokemonName());
            response.setBaseExperience(pokemon.getBaseExperience());
            return response;
        });
    }
    @Override
    public HeldItemResponse getHeldItem(HeldItemRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_HELD_ITEM, request, req -> {
            HeldItemResponse response = new HeldItemResponse();
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(request.getPokemonName());
            response.setHeldItem(pokemon.getHeldItems());
            return response;
        });
    }
    @Override
    public LocationAreaEncountersResponse getLocationAreaEncounters(LocationAreaEncountersRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_LOCATION_AREA_ENCOUNTERS, request, req -> {
            LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(request.getPokemonName());
            response.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());
            return response;
        });
    }
    @Override
    public NameResponse getName(NameRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_NAME, request, req -> {
            NameResponse response = new NameResponse();
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(request.getPokemonName());
            response.setName(pokemon.getName());
            return response;
        });
    }
    @Override
    public IdResponse getId(IdRequest request) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_ID, request, req -> {
            IdResponse response = new IdResponse();
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(request.getPokemonName());
            response.setId(pokemon.getId());
            return response;
        });
    }


    // Método genérico para procesar la petición y registrar en bitácora
    private <T, R> R procesarConBitacora(String metodo, T request, Function<T, R> funcion) {
        long start = System.currentTimeMillis();
        R response = funcion.apply(request);
        long end = System.currentTimeMillis();
        registrarBitacora(metodo, request, response, end - start);
        return response;
    }


    // Método privado para registrar en bitácora
    private void registrarBitacora(String metodo, Object request, Object response, long tiempoPeticion) {
        String clientIp = (String) httpServletRequest.getAttribute("clientIp");
        Bitacora bitacora = new Bitacora();
        bitacora.setIpOrigen(clientIp);
        bitacora.setMetodo(metodo);
        bitacora.setFechaRequest(LocalDateTime.now());
        bitacora.setTiempoPeticion(tiempoPeticion);
        try {
            bitacora.setRequest(objectMapper.writeValueAsString(request));
            bitacora.setResponse(objectMapper.writeValueAsString(response));
        } catch (Exception e) {
            log.error("Error serializando: " + e.getMessage());
        }
        bitacoraService.guardar(bitacora);
    }

}