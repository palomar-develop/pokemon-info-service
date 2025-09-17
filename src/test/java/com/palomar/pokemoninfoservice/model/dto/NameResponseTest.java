package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameResponseTest {
    @Test
    void testSetAndGetName() {
        NameResponse response = new NameResponse();
        response.setName("pikachu");
        assertEquals("pikachu", response.getName());
    }

    @Test
    void testNoArgsConstructor() {
        NameResponse response = new NameResponse();
        assertNull(response.getName());
    }
}

