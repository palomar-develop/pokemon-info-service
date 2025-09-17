package com.palomar.pokemoninfoservice.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.domain.port.out.PokemonApiService;
import com.palomar.pokemoninfoservice.domain.port.in.PokemonService;
import com.palomar.pokemoninfoservice.domain.port.in.BitacoraService;
import com.palomar.pokemoninfoservice.domain.model.Bitacora;
import com.palomar.pokemoninfoservice.domain.model.dto.*;
import com.palomar.pokemoninfoservice.infrastructure.utils.PokemonServiceConstants;
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
public class PokemonServiceImpl implements PokemonService {

    private final PokemonApiService pokemonApiService;
    private final BitacoraService bitacoraService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    public PokemonServiceImpl(PokemonApiService pokemonApiService, BitacoraService bitacoraService) {
        this.pokemonApiService = pokemonApiService;
        this.bitacoraService = bitacoraService;
    }

    /***
     * Implementación del método para obtener las habilidades de un Pokémon por su nombre.
     *
     * @param pokemonName La solicitud que contiene el nombre del Pokémon.
     * @return La respuesta con las habilidades del Pokémon.
     */
    @Override
    public AbilitiesResponse getAbilities(String pokemonName) {

        return procesarConBitacora(PokemonServiceConstants.METHOD_ABILITIES, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            AbilitiesResponse response = new AbilitiesResponse();
            response.setAbilities(pokemon.getAbilities());
            return response;
        });
    }

    /**
     * Implementación del método para obtener la experiencia base de un Pokémon por su nombre.
     * @param pokemonName
     * @return
     */
    @Override
    public BaseExperienceResponse getBaseExperience(String pokemonName) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_BASE_EXPERIENCE, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            BaseExperienceResponse response = new BaseExperienceResponse();
            response.setBaseExperience(pokemon.getBaseExperience());
            return response;
        });
    }

    /**
     * Implementación del método para obtener los objetos que sostiene un Pokémon por su nombre.
     * @param pokemonName
     * @return
     */
    @Override
    public HeldItemResponse getHeldItem(String pokemonName) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_HELD_ITEM, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            HeldItemResponse response = new HeldItemResponse();
            response.setHeldItem(pokemon.getHeldItems());
            return response;
        });
    }

  /**
     * Implementación del método para obtener las áreas de encuentro de un Pokémon por su nombre.
     * @param pokemonName
     * @return
     */
    @Override
    public LocationAreaEncountersResponse getLocationAreaEncounters(String pokemonName) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_LOCATION_AREA_ENCOUNTERS, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
            response.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());
            return response;
        });
    }

    /**
     * Implementación del método para obtener el nombre de un Pokémon por su nombre.
     * @param pokemonName
     * @return
     */
    @Override
    public NameResponse getName(String pokemonName) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_NAME, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            NameResponse response = new NameResponse();
            response.setName(pokemon.getName());
            return response;
        });
    }

    /**
     * Implementación del método para obtener el ID de un Pokémon por su nombre.
     * @param pokemonName
     * @return
     */
    @Override
    public IdResponse getId(String pokemonName) {
        return procesarConBitacora(PokemonServiceConstants.METHOD_ID, pokemonName, req -> {
            PokemonResponse pokemon = pokemonApiService.getPokemonByName(req);
            IdResponse response = new IdResponse();
            response.setId(pokemon.getId());
            return response;
        });
    }


    /***
     * Método genérico para procesar la petición y registrar en bitácora.
     *
     * @param metodo   El nombre del método que se está procesando.
     * @param request  La solicitud entrante.
     * @param funcion  La función que procesa la solicitud y devuelve la respuesta.
     * @param <T>      El tipo de la solicitud.
     * @param <R>      El tipo de la respuesta.
     * @return La respuesta procesada.
     */
    private <T, R> R procesarConBitacora(String metodo, T request, Function<T, R> funcion) {
        long start = System.currentTimeMillis();
        R response = funcion.apply(request);
        long end = System.currentTimeMillis();
        registrarBitacora(metodo, request, response, end - start);
        return response;
    }



    /***
     * Registra los detalles de la petición y respuesta en la bitácora.
     *
     * @param metodo         El nombre del método que se está procesando.
     * @param request        La solicitud entrante.
     * @param response       La respuesta generada.
     * @param tiempoPeticion El tiempo que tomó procesar la petición en milisegundos.
     */
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