package com.palomar.pokemoninfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokemonInfoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonInfoServiceApplication.class, args);
    }
}