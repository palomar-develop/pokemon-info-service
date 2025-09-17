package com.palomar.pokemoninfoservice.client.model;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.PokemonResponse;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class PokemonResponseTest {
    @Test
    void testBuilderAndGetters() {

        PokemonResponse response = new PokemonResponse();
        response.setId(25);
        response.setName("pikachu");
        response.setBaseExperience(112);
        response.setAbilities(Collections.emptyList());
        response.setHeldItems(Collections.emptyList());
        response.setLocationAreaEncounters("test-location");
        assertEquals(25, response.getId());
        assertEquals("pikachu", response.getName());
        assertEquals(112, response.getBaseExperience());
        assertEquals(Collections.emptyList(), response.getAbilities());
        assertEquals(Collections.emptyList(), response.getHeldItems());
        assertEquals("test-location", response.getLocationAreaEncounters());
    }

    @Test
    void testNoArgsConstructor() {

        PokemonResponse response = new PokemonResponse();
        assertNull(response.getId());
        assertNull(response.getName());
        assertNull(response.getBaseExperience());
        assertNull(response.getAbilities());
        assertNull(response.getHeldItems());
        assertNull(response.getLocationAreaEncounters());
    }
}
