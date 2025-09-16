package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.model.dto.*;
import com.palomar.pokemoninfoservice.service.PokemonService;
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
    private PokemonService pokemonService;
    @InjectMocks
    private PokemonSoapController pokemonSOAPController;

    @Test
    void handleAbilitiesReturnsAbilitiesResponse() {

        String pokemonName = "pikachu";
        AbilitiesResponse responseExpected = new AbilitiesResponse();
        responseExpected.setAbilities(Collections.emptyList());
        when(pokemonService.getAbilities(pokemonName)).thenReturn(responseExpected);

        AbilitiesResponse response = pokemonSOAPController.handleAbilities(pokemonName);
        assertEquals(Collections.emptyList(), response.getAbilities());
        verify(pokemonService, times(1)).getAbilities(pokemonName);
    }

    @Test
    void handleBaseExperienceReturnsBaseExperienceResponse() {
        String pokemonName = "pikachu";
        BaseExperienceResponse responseExpected = new BaseExperienceResponse();
        responseExpected.setBaseExperience(112);
        when(pokemonService.getBaseExperience(pokemonName)).thenReturn(responseExpected);

        BaseExperienceResponse response = pokemonSOAPController.handleBaseExperience(pokemonName);
        assertEquals(112, response.getBaseExperience());
        verify(pokemonService, times(1)).getBaseExperience(pokemonName);
    }

    @Test
    void handleHeldItemReturnsHeldItemResponse() {
        String pokemonName = "pikachu";
        HeldItemResponse responseMock = new HeldItemResponse();
        responseMock.setHeldItem(Collections.emptyList());
        when(pokemonService.getHeldItem(pokemonName)).thenReturn(responseMock);

        HeldItemResponse response = pokemonSOAPController.handleHeldItem(pokemonName);
        assertEquals(Collections.emptyList(), response.getHeldItem());
        verify(pokemonService, times(1)).getHeldItem(pokemonName);
    }

    @Test
    void handleLocationAreaEncountersReturnsLocationAreaEncountersResponse() {
        String pokemonName = "pikachu";
        LocationAreaEncountersResponse responseMock = new LocationAreaEncountersResponse();
        responseMock.setLocationAreaEncounters("test-location");
        when(pokemonService.getLocationAreaEncounters(pokemonName)).thenReturn(responseMock);

        LocationAreaEncountersResponse response = pokemonSOAPController.handleLocationAreaEncounters(pokemonName);
        assertEquals("test-location", response.getLocationAreaEncounters());
        verify(pokemonService, times(1)).getLocationAreaEncounters(pokemonName);
    }

    @Test
    void handleNameReturnsNameResponse() {
        String pokemonName = "pikachu";
        NameResponse responseMock = new NameResponse();
        responseMock.setName("pikachu");
        when(pokemonService.getName(pokemonName)).thenReturn(responseMock);

        NameResponse response = pokemonSOAPController.handleName(pokemonName);
        assertEquals("pikachu", response.getName());
        verify(pokemonService, times(1)).getName(pokemonName);
    }

    @Test
    void handleIdReturnsIdResponse() {
        String pokemonName = "pikachu";
        IdResponse responseMock = new IdResponse();
        responseMock.setId(25);
        when(pokemonService.getId(pokemonName)).thenReturn(responseMock);

        IdResponse response = pokemonSOAPController.handleId(pokemonName);
        assertEquals(25, response.getId());
        verify(pokemonService, times(1)).getId(pokemonName);
    }

    @Test
    void handleAbilitiesWhenNotFoundThrowsException() {
        String pokemonName = "missingno";
        when(pokemonService.getAbilities(pokemonName)).thenThrow(new PokemonNotFoundException("No se encontró el pokemon: missingno"));

        assertThrows(PokemonNotFoundException.class, () -> pokemonSOAPController.handleAbilities(pokemonName));
        verify(pokemonService, times(1)).getAbilities(pokemonName);
    }
}
