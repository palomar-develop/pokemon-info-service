package com.palomar.pokemoninfoservice.client.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class AbilityTest {
    @Test
    void testSetAndGetName() {
        Ability ability = new Ability();
        ability.setName("static");
        ability.setUrl("https://pokeapi.co/api/v2/ability/9/");
        assertEquals("https://pokeapi.co/api/v2/ability/9/", ability.getUrl());
        assertEquals("static", ability.getName());
    }

    @Test
    void testNoArgsConstructor() {
        Ability ability = new Ability();
        assertNull(ability.getName());
    }
}
