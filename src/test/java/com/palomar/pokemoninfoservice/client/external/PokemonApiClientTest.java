package com.palomar.pokemoninfoservice.client.external;


import com.palomar.pokemoninfoservice.client.external.impl.PokemonApiClientImpl;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.config.PokemonApiProperties;
import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@ExtendWith(MockitoExtension.class)
class PokemonApiClientTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private PokemonApiProperties pokemonApiProperties;
    @InjectMocks
    private PokemonApiClientImpl pokemonApiClient;


    @Test
    void getPokemonByNameWhenNotFoundThrowsPokemonNotFoundException() {
        String pokemonName = "missingno";
        String baseUrl = "https://pokeapi.co/api/v2/pokemon/";
        String expectedUrl = baseUrl + pokemonName;
        when(pokemonApiProperties.getBaseUrl()).thenReturn(baseUrl);
        when(restTemplate.getForObject(expectedUrl, PokemonResponse.class))
                .thenThrow(new PokemonNotFoundException(Constants.POKEMON_NOT_FOUND_MESSAGE + pokemonName));

        PokemonNotFoundException exception = assertThrows(PokemonNotFoundException.class,
                () -> pokemonApiClient.getPokemonByName(pokemonName));
        assertEquals(Constants.POKEMON_NOT_FOUND_MESSAGE + pokemonName, exception.getMessage());
        verify(restTemplate, times(1)).getForObject(expectedUrl, PokemonResponse.class);

    }
    @Test
    void getPokemonByNameReturnsPokemonResponse() {
        String pokemonName = "pikachu";
        String baseUrl = "https://pokeapi.co/api/v2/pokemon/";
        String expectedUrl = baseUrl + pokemonName;
        PokemonResponse expectedResponse = new PokemonResponse();
        expectedResponse.setId(25);
        expectedResponse.setName("pikachu");

        when(pokemonApiProperties.getBaseUrl()).thenReturn(baseUrl);
        when(restTemplate.getForObject(expectedUrl, PokemonResponse.class)).thenReturn(expectedResponse);

        PokemonResponse actualResponse = pokemonApiClient.getPokemonByName(pokemonName);

        assertEquals(expectedResponse, actualResponse);
        verify(restTemplate, times(1)).getForObject(expectedUrl, PokemonResponse.class);
    }
}