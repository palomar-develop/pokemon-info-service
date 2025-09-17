package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.model.dto.AbilitiesResponse;
import com.palomar.pokemoninfoservice.model.dto.BaseExperienceResponse;
import com.palomar.pokemoninfoservice.model.dto.HeldItemResponse;
import com.palomar.pokemoninfoservice.model.dto.LocationAreaEncountersResponse;
import com.palomar.pokemoninfoservice.model.dto.NameResponse;
import com.palomar.pokemoninfoservice.model.dto.IdResponse;
import com.palomar.pokemoninfoservice.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PokemonController.class)
class PokemonControllerWebTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void getAbilitiesReturnsAbilitiesResponse() throws Exception {
        AbilitiesResponse response = new AbilitiesResponse();
        when(pokemonService.getAbilities("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/abilities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getAbilities("pikachu");
    }

    @Test
    void getBaseExperienceReturnsBaseExperienceResponse() throws Exception {
        BaseExperienceResponse response = new BaseExperienceResponse();
        response.setBaseExperience(112);
        when(pokemonService.getBaseExperience("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/base-experience")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getBaseExperience("pikachu");
    }

    @Test
    void getHeldItemReturnsHeldItemResponse() throws Exception {
        HeldItemResponse response = new HeldItemResponse();
        when(pokemonService.getHeldItem("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/held-items")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getHeldItem("pikachu");
    }

    @Test
    void getLocationAreaEncountersReturnsLocationAreaEncountersResponse() throws Exception {
        LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
        response.setLocationAreaEncounters("forest");
        when(pokemonService.getLocationAreaEncounters("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/location-area-encounters")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getLocationAreaEncounters("pikachu");
    }

    @Test
    void getNameReturnsNameResponse() throws Exception {
        NameResponse response = new NameResponse();
        response.setName("pikachu");
        when(pokemonService.getName("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getName("pikachu");
    }

    @Test
    void getIdReturnsIdResponse() throws Exception {
        IdResponse response = new IdResponse();
        response.setId(25);
        when(pokemonService.getId("pikachu")).thenReturn(response);

        mockMvc.perform(get("/v1/pokemon/pikachu/id")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(pokemonService, times(1)).getId("pikachu");
    }
}

