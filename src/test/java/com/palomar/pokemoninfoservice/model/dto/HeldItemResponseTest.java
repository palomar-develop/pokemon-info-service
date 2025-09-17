package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.domain.model.dto.HeldItemResponse;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class HeldItemResponseTest {
    @Test
    void testSetAndGetHeldItem() {
        HeldItemResponse response = new HeldItemResponse();
        response.setHeldItem(Collections.emptyList());
        assertEquals(Collections.emptyList(), response.getHeldItem());
    }

    @Test
    void testNoArgsConstructor() {
        HeldItemResponse response = new HeldItemResponse();
        assertNull(response.getHeldItem());
    }
}

