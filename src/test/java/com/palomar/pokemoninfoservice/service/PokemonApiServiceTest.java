package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.infrastructure.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.application.service.impl.PokemonApiServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonApiServiceTest {
    @Mock
    private PokemonApiClient pokeApiClient;
    @InjectMocks
    private PokemonApiServiceImpl pokemonApiService;

    @Test
    void getPokemonByName() {
        String pokemonName = "pikachu";
        PokemonResponse expectedResponse = new PokemonResponse();
        expectedResponse.setId(25);
        expectedResponse.setName("pikachu");
        expectedResponse.setBaseExperience(112);
        when(pokeApiClient.getPokemonByName(pokemonName)).thenReturn(expectedResponse);

        PokemonResponse actualResponse = pokemonApiService.getPokemonByName(pokemonName);

        assertEquals(expectedResponse, actualResponse);
        verify(pokeApiClient, times(1)).getPokemonByName(pokemonName);
    }

    @Test
    void getPokemonByNameWhenNotFoundThrowsException() {
        String pokemonName = "missingno";
        when(pokeApiClient.getPokemonByName(pokemonName)).thenThrow(new PokemonNotFoundException("No se encontró el pokemon: " + pokemonName));

        assertThrows(PokemonNotFoundException.class, () -> pokemonApiService.getPokemonByName(pokemonName));
        verify(pokeApiClient, times(1)).getPokemonByName(pokemonName);
    }

}
