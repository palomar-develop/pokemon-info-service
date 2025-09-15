package com.palomar.pokemoninfoservice.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseExperienceResponseTest {
    @Test
    void testSetAndGetBaseExperience() {
        BaseExperienceResponse response = new BaseExperienceResponse();
        response.setBaseExperience(112);
        assertEquals(112, response.getBaseExperience());
    }

    @Test
    void testNoArgsConstructor() {
        BaseExperienceResponse response = new BaseExperienceResponse();
        assertNull( response.getBaseExperience());
    }
}

