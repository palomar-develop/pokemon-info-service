package com.palomar.pokemoninfoservice.client.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
class AbilitySlotTest {
    @Test
    void testSetAndGetAbility() {
        AbilitySlot slot = new AbilitySlot();
        Ability ability = new Ability();
        ability.setName("static");
        slot.setAbility(ability);
        assertEquals("static", slot.getAbility().getName());
    }

    @Test
    void testSetAndGetIsHidden() {
        AbilitySlot slot = new AbilitySlot();
        slot.setIsHidden(true);
        assertTrue(slot.getIsHidden());
    }

    @Test
    void testSetAndGetSlot() {
        AbilitySlot slot = new AbilitySlot();
        slot.setSlot(1);
        assertEquals(1, slot.getSlot());
    }

    @Test
    void testNoArgsConstructor() {
        AbilitySlot slot = new AbilitySlot();
        assertNull(slot.getAbility());
        assertNull(slot.getIsHidden());
        assertNull(slot.getSlot());
    }
}
