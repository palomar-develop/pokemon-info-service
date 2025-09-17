package com.palomar.pokemoninfoservice.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PokemonServiceConstantsTest {
    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<PokemonServiceConstants> constructor = PokemonServiceConstants.class.getDeclaredConstructor();
        Exception exception = assertThrows(IllegalAccessException.class, constructor::newInstance);
        assertNotNull(exception);
    }
}

