package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationAreaEncountersResponseTest {
    @Test
    void testSetAndGetLocationAreaEncounters() {
        LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
        response.setLocationAreaEncounters("test-location");
        assertEquals("test-location", response.getLocationAreaEncounters());
    }

    @Test
    void testNoArgsConstructor() {
        LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
        assertNull(response.getLocationAreaEncounters());
    }
}

