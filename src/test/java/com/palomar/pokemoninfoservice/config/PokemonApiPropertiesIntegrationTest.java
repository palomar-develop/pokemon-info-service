package com.palomar.pokemoninfoservice.config;

import com.palomar.pokemoninfoservice.infrastructure.config.PokemonApiProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "pokeapi.base-url=https://pokeapi.co/api/v2/pokemon/")
class PokemonApiPropertiesIntegrationTest {
    @Autowired
    private PokemonApiProperties properties;

    @Test
    void testBaseUrlMapping() {
        assertEquals("https://pokeapi.co/api/v2/pokemon/", properties.getBaseUrl());
    }
}

