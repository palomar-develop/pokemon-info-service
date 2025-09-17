package com.palomar.pokemoninfoservice.client.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VersionDetailTest {
    @Test
    void testSetAndGetRarity() {
        VersionDetail versionDetail = new VersionDetail();
        versionDetail.setRarity(5);
        assertEquals(5, versionDetail.getRarity());
    }

    @Test
    void testSetAndGetVersion() {
        VersionDetail versionDetail = new VersionDetail();
        Version version = new Version();
        version.setName("red");
        versionDetail.setVersion(version);
        assertEquals("red", versionDetail.getVersion().getName());
    }

    @Test
    void testNoArgsConstructor() {
        VersionDetail versionDetail = new VersionDetail();
        assertNull(versionDetail.getRarity());
        assertNull(versionDetail.getVersion());
    }
}

