package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.domain.model.dto.NameRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        NameRequest request = new NameRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        NameRequest request = new NameRequest();
        assertNull(request.getPokemonName());
    }
}

