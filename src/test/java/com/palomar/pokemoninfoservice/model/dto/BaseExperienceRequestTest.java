package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseExperienceRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        BaseExperienceRequest request = new BaseExperienceRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        BaseExperienceRequest request = new BaseExperienceRequest();
        assertNull(request.getPokemonName());
    }
}

