package com.palomar.pokemoninfoservice.exception;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
