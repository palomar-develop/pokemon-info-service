package com.palomar.pokemoninfoservice.client.model;

import com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class ItemTest {
    @Test
    void testSetAndGetName() {
        Item item = new Item();
        item.setName("potion");
        item.setUrl("https://pokeapi.co/api/v2/item/1/");
        assertEquals("https://pokeapi.co/api/v2/item/1/", item.getUrl());
        assertEquals("potion", item.getName());
    }

    @Test
    void testNoArgsConstructor() {
        Item item = new Item();
        assertNull(item.getName());
    }
}
