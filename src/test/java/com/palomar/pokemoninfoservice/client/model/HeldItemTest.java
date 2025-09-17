package com.palomar.pokemoninfoservice.client.model;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class HeldItemTest {
    @Test
    void testSetAndGetItem() {
        HeldItem heldItem = new HeldItem();
        Item item = new Item();
        item.setName("potion");
        heldItem.setItem(item);
        assertEquals("potion", heldItem.getItem().getName());
    }

    @Test
    void testSetAndGetVersionDetails() {
        HeldItem heldItem = new HeldItem();
        VersionDetail versionDetail = new VersionDetail();
        versionDetail.setRarity(5);
        heldItem.setVersionDetails(Collections.singletonList(versionDetail));
        assertEquals(5, heldItem.getVersionDetails().get(0).getRarity());
    }

    @Test
    void testNoArgsConstructor() {
        HeldItem heldItem = new HeldItem();
        assertNull(heldItem.getItem());
        assertNull(heldItem.getVersionDetails());
    }
}
