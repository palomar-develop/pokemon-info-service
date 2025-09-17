package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdResponseTest {
    @Test
    void testSetAndGetId() {
        IdResponse response = new IdResponse();
        response.setId(25);
        assertEquals(25, response.getId());
    }

    @Test
    void testNoArgsConstructor() {
        IdResponse response = new IdResponse();
        assertNull( response.getId());
    }
}

