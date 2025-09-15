package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.model.dto.*;
import com.palomar.pokemoninfoservice.service.PokemonSoapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonSoapControllerTest {
    @Mock
    private PokemonSoapService pokemonSOAPService;
    @InjectMocks
    private PokemonSoapController pokemonSOAPController;

    @Test
    void handleAbilitiesReturnsAbilitiesResponse() {
        AbilitiesRequest request = new AbilitiesRequest();
        request.setPokemonName("pikachu");
        AbilitiesResponse responseExpected = new AbilitiesResponse();
        responseExpected.setAbilities(Collections.emptyList());
        when(pokemonSOAPService.getAbilities(request)).thenReturn(responseExpected);

        AbilitiesResponse response = pokemonSOAPController.handleAbilities(request);
        assertEquals(Collections.emptyList(), response.getAbilities());
        verify(pokemonSOAPService, times(1)).getAbilities(request);
    }

    @Test
    void handleBaseExperienceReturnsBaseExperienceResponse() {
        BaseExperienceRequest request = new BaseExperienceRequest();
        request.setPokemonName("pikachu");

        BaseExperienceResponse responseExpected = new BaseExperienceResponse();
        responseExpected.setBaseExperience(112);

        when(pokemonSOAPService.getBaseExperience(request)).thenReturn(responseExpected);

        BaseExperienceResponse response = pokemonSOAPController.handleBaseExperience(request);
        assertEquals(112, response.getBaseExperience());
        verify(pokemonSOAPService, times(1)).getBaseExperience(request);
    }

    @Test
    void handleHeldItemReturnsHeldItemResponse() {
        HeldItemRequest request = new HeldItemRequest();
        request.setPokemonName("pikachu");

        HeldItemResponse responseMock = new HeldItemResponse();
        responseMock.setHeldItem(Collections.emptyList());

        when(pokemonSOAPService.getHeldItem(request)).thenReturn(responseMock);

        HeldItemResponse response = pokemonSOAPController.handleHeldItem(request);
        assertEquals(Collections.emptyList(), response.getHeldItem());
        verify(pokemonSOAPService, times(1)).getHeldItem(request);
    }

    @Test
    void handleLocationAreaEncountersReturnsLocationAreaEncountersResponse() {
        LocationAreaEncountersRequest request = new LocationAreaEncountersRequest();
        request.setPokemonName("pikachu");

        LocationAreaEncountersResponse responseMock = new LocationAreaEncountersResponse();
        responseMock.setLocationAreaEncounters("test-location");

        when(pokemonSOAPService.getLocationAreaEncounters(request)).thenReturn(responseMock);

        LocationAreaEncountersResponse response = pokemonSOAPController.handleLocationAreaEncounters(request);
        assertEquals("test-location", response.getLocationAreaEncounters());
        verify(pokemonSOAPService, times(1)).getLocationAreaEncounters(request);
    }

    @Test
    void handleNameReturnsNameResponse() {
        NameRequest request = new NameRequest();
        request.setPokemonName("pikachu");

        NameResponse responseMock = new NameResponse();
        responseMock.setName("pikachu");

        when(pokemonSOAPService.getName(request)).thenReturn(responseMock);

        NameResponse response = pokemonSOAPController.handleName(request);
        assertEquals("pikachu", response.getName());
        verify(pokemonSOAPService, times(1)).getName(request);
    }

    @Test
    void handleIdReturnsIdResponse() {
        IdRequest request = new IdRequest();
        request.setPokemonName("pikachu");

        IdResponse responseMock = new IdResponse();
        responseMock.setId(25);

        when(pokemonSOAPService.getId(request)).thenReturn(responseMock);

        IdResponse response = pokemonSOAPController.handleId(request);
        assertEquals(25, response.getId());
        verify(pokemonSOAPService, times(1)).getId(request);
    }

    @Test
    void handleAbilitiesWhenNotFoundThrowsException() {
        AbilitiesRequest request = new AbilitiesRequest();
        request.setPokemonName("missingno");
        when(pokemonSOAPService.getAbilities(request)).thenThrow(new PokemonNotFoundException("No se encontró el pokemon: missingno"));

        assertThrows(PokemonNotFoundException.class, () -> pokemonSOAPController.handleAbilities(request));
        verify(pokemonSOAPService, times(1)).getAbilities(request);
    }
}
