package com.palomar.pokemoninfoservice.model.entity;

import com.palomar.pokemoninfoservice.domain.model.Bitacora;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class BitacoraTest {
    @Test
    void testGettersAndSetters() {
        Bitacora bitacora = new Bitacora();
        bitacora.setId(1L);
        bitacora.setIpOrigen("127.0.0.1");
        LocalDateTime now = LocalDateTime.now();
        bitacora.setFechaRequest(now);
        bitacora.setMetodo("GET");
        bitacora.setRequest("request");
        bitacora.setTiempoPeticion(100L);
        bitacora.setResponse("response");

        assertEquals(1L, bitacora.getId());
        assertEquals("127.0.0.1", bitacora.getIpOrigen());
        assertEquals(now, bitacora.getFechaRequest());
        assertEquals("GET", bitacora.getMetodo());
        assertEquals("request", bitacora.getRequest());
        assertEquals(100L, bitacora.getTiempoPeticion());
        assertEquals("response", bitacora.getResponse());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        Bitacora bitacora = new Bitacora(1L, "127.0.0.1", now, "POST", "req", 200L, "resp");
        assertEquals(1L, bitacora.getId());
        assertEquals("127.0.0.1", bitacora.getIpOrigen());
        assertEquals(now, bitacora.getFechaRequest());
        assertEquals("POST", bitacora.getMetodo());
        assertEquals("req", bitacora.getRequest());
        assertEquals(200L, bitacora.getTiempoPeticion());
        assertEquals("resp", bitacora.getResponse());
    }
}

