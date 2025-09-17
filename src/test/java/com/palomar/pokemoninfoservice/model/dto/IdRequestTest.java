package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        IdRequest request = new IdRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        IdRequest request = new IdRequest();
        assertNull(request.getPokemonName());
    }
}
