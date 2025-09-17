package com.palomar.pokemoninfoservice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IpInterceptorTest {
    @Test
    void testPreHandleWithHeader() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getHeader("X-Forwarded-For")).thenReturn("8.8.8.8");
        Mockito.when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        IpInterceptor interceptor = new IpInterceptor();
        boolean result = interceptor.preHandle(request, response, new Object());
        assertTrue(result);
        Mockito.verify(request).setAttribute("clientIp", "8.8.8.8");
    }

    @Test
    void testPreHandleWithoutHeader() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getHeader("X-Forwarded-For")).thenReturn(null);
        Mockito.when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        IpInterceptor interceptor = new IpInterceptor();
        boolean result = interceptor.preHandle(request, response, new Object());
        assertTrue(result);
        Mockito.verify(request).setAttribute("clientIp", "127.0.0.1");
    }
}

