package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.domain.model.dto.HeldItemRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeldItemRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        HeldItemRequest request = new HeldItemRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        HeldItemRequest request = new HeldItemRequest();
        assertNull(request.getPokemonName());
    }
}

