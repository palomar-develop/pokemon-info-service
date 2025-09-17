package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class AbilitiesResponseTest {
    @Test
    void testSetAndGetAbilities() {
        AbilitiesResponse response = new AbilitiesResponse();
        response.setAbilities(Collections.emptyList());
        assertEquals(Collections.emptyList(), response.getAbilities());
    }

    @Test
    void testNoArgsConstructor() {
        AbilitiesResponse response = new AbilitiesResponse();
        assertNull(response.getAbilities());
    }
}

