package com.palomar.pokemoninfoservice.exception;

import com.palomar.pokemoninfoservice.infrastructure.exception.PokemonNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonNotFoundExceptionTest {
    @Test
    void testMessage() {
        String msg = "No se encontró el pokemon: pikachu";
        PokemonNotFoundException ex = new PokemonNotFoundException(msg);
        assertEquals(msg, ex.getMessage());
    }
}

