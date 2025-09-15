package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {
    @Mock
    private PokemonApiService pokemonApiService;
    @InjectMocks
    private PokemonController controller;

    @Test
    void getPokemonByName() {
        String pokemonName = "pikachu";
        PokemonResponse expectedResponse = new PokemonResponse();
        expectedResponse.setId(25);
        expectedResponse.setName("pikachu");
        expectedResponse.setBaseExperience(112);
        when(pokemonApiService.getPokemonByName(pokemonName)).thenReturn(expectedResponse);

        PokemonResponse actualResponse = controller.getPokemonByName(pokemonName);

        assertEquals(expectedResponse.getName(), actualResponse.getName());
        verify(pokemonApiService).getPokemonByName(pokemonName);
    }
}
