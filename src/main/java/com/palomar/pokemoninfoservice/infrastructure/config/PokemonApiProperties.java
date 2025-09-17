package com.palomar.pokemoninfoservice.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pokeapi")
@Getter
@Setter
public class PokemonApiProperties {
    private String baseUrl;
}


