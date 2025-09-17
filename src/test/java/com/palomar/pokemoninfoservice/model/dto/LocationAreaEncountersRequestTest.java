package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.domain.model.dto.LocationAreaEncountersRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationAreaEncountersRequestTest {
    @Test
    void testSetAndGetPokemonName() {
        LocationAreaEncountersRequest request = new LocationAreaEncountersRequest();
        request.setPokemonName("pikachu");
        assertEquals("pikachu", request.getPokemonName());
    }

    @Test
    void testNoArgsConstructor() {
        LocationAreaEncountersRequest request = new LocationAreaEncountersRequest();
        assertNull(request.getPokemonName());
    }
}
