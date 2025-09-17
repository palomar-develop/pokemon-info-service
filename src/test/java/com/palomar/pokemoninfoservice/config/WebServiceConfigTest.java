package com.palomar.pokemoninfoservice.config;

import com.palomar.pokemoninfoservice.infrastructure.config.WebServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import static org.junit.jupiter.api.Assertions.*;

class WebServiceConfigTest {
    @Test
    void testBeansCreation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebServiceConfig.class);
        assertNotNull(context.getBean("messageDispatcherServlet"));
        assertNotNull(context.getBean("pokemon"));
        assertNotNull(context.getBean("pokemonSchema"));
        assertNotNull(context.getBean(SoapFaultMappingExceptionResolver.class));
        context.close();
    }

    @Test
    void testExceptionResolverMappings() {
        WebServiceConfig config = new WebServiceConfig();
        SoapFaultMappingExceptionResolver resolver = config.exceptionResolver();
        assertEquals(1, resolver.getOrder());
      }
}

