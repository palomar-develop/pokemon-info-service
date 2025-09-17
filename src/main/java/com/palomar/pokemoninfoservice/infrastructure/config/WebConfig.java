package com.palomar.pokemoninfoservice.infrastructure.config;

import com.palomar.pokemoninfoservice.infrastructure.interceptor.IpInterceptor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@OpenAPIDefinition(
        info = @Info(
                title = "API para consultar información de Pokémon",
                version = "v1",
                description = "API para consultar información de Pokémon"
        )
)
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private IpInterceptor ipInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor);
    }
}
