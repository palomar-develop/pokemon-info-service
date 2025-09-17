package com.palomar.pokemoninfoservice.client.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class VersionTest {
    @Test
    void testSetAndGetName() {
        Version version = new Version();
        version.setName("red");
        version.setUrl("https://pokeapi.co/api/v2/version/1/");
        assertEquals("https://pokeapi.co/api/v2/version/1/", version.getUrl());
        assertEquals("red", version.getName());
    }

    @Test
    void testNoArgsConstructor() {
        Version version = new Version();
        assertNull(version.getName());
    }
}
