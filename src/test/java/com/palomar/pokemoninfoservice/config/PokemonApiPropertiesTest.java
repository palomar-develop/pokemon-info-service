package com.palomar.pokemoninfoservice.config;

import com.palomar.pokemoninfoservice.infrastructure.config.PokemonApiProperties;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonApiPropertiesTest {

    @Test
    void testNoArgsConstructor() {
        PokemonApiProperties properties = new PokemonApiProperties();
        assertNull(properties.getBaseUrl());
    }
}

