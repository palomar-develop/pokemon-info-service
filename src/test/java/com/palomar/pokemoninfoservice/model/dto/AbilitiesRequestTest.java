package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.domain.model.dto.AbilitiesRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbilitiesRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        AbilitiesRequest request = new AbilitiesRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        AbilitiesRequest request = new AbilitiesRequest();
        assertNull(request.getPokemonName());
    }
}

