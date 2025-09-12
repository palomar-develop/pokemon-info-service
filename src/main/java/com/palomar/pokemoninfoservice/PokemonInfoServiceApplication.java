package com.palomar.pokemoninfoservice;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
@Log4j2
public class PokemonInfoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonInfoServiceApplication.class, args);
        log.info("Aplicación iniciada con Log4j 2!");

    }
}