package com.palomar.pokemoninfoservice.config;

import com.palomar.pokemoninfoservice.interceptor.IpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private IpInterceptor ipInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor);
    }
}
