package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.domain.model.dto.*;
import com.palomar.pokemoninfoservice.domain.port.in.PokemonService;
import com.palomar.pokemoninfoservice.infrastructure.adapter.in.rest.PokemonController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {
    @Mock
    private PokemonService pokemonService;
    @InjectMocks
    private PokemonController pokemonController;

    @Test
    void getAbilitiesReturnsAbilitiesResponse() {
        String pokemonName = "pikachu";
        AbilitiesResponse expected = new AbilitiesResponse();
        when(pokemonService.getAbilities(pokemonName)).thenReturn(expected);
        ResponseEntity<AbilitiesResponse> result = pokemonController.getAbilities(pokemonName);
        assertEquals(expected, result.getBody());
        verify(pokemonService, times(1)).getAbilities(pokemonName);
    }

    @Test
    void getBaseExperienceReturnsBaseExperienceResponse() {
        String pokemonName = "pikachu";
        BaseExperienceResponse expected = new BaseExperienceResponse();
        expected.setBaseExperience(112);
        when(pokemonService.getBaseExperience(pokemonName)).thenReturn(expected);
        ResponseEntity<BaseExperienceResponse> result = pokemonController.getBaseExperience(pokemonName);
        assertNotNull(result.getBody());
        assertEquals(112, result.getBody().getBaseExperience());
        verify(pokemonService, times(1)).getBaseExperience(pokemonName);
    }

    @Test
    void getHeldItemReturnsHeldItemResponse() {
        String pokemonName = "pikachu";
        HeldItemResponse expected = new HeldItemResponse();
        when(pokemonService.getHeldItem(pokemonName)).thenReturn(expected);
        ResponseEntity<HeldItemResponse> result = pokemonController.getHeldItem(pokemonName);
        assertEquals(expected, result.getBody());
        verify(pokemonService, times(1)).getHeldItem(pokemonName);
    }

    @Test
    void getLocationAreaEncountersReturnsLocationAreaEncountersResponse() {
        String pokemonName = "pikachu";
        LocationAreaEncountersResponse expected = new LocationAreaEncountersResponse();
        expected.setLocationAreaEncounters("forest");
        when(pokemonService.getLocationAreaEncounters(pokemonName)).thenReturn(expected);
        ResponseEntity<LocationAreaEncountersResponse> result = pokemonController.getLocationAreaEncounters(pokemonName);
        assertNotNull(result.getBody());
        assertEquals("forest", result.getBody().getLocationAreaEncounters());
        verify(pokemonService, times(1)).getLocationAreaEncounters(pokemonName);
    }

    @Test
    void getNameReturnsNameResponse() {
        String pokemonName = "pikachu";
        NameResponse expected = new NameResponse();
        expected.setName("pikachu");
        when(pokemonService.getName(pokemonName)).thenReturn(expected);
        ResponseEntity<NameResponse> result = pokemonController.getName(pokemonName);
        assertNotNull(result.getBody());
        assertEquals("pikachu", result.getBody().getName());
        verify(pokemonService, times(1)).getName(pokemonName);
    }

    @Test
    void getIdReturnsIdResponse() {
        String pokemonName = "pikachu";
        IdResponse expected = new IdResponse();
        expected.setId(25);
        when(pokemonService.getId(pokemonName)).thenReturn(expected);
        ResponseEntity<IdResponse> result = pokemonController.getId(pokemonName);
        assertNotNull(result.getBody());
        assertEquals(25, result.getBody().getId());
        verify(pokemonService, times(1)).getId(pokemonName);
    }
}
