package com.palomar.pokemoninfoservice.utils;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {
    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
        Exception exception = assertThrows(IllegalAccessException.class, constructor::newInstance);
        assertNotNull(exception);
    }
}

