package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@RestController
@RequestMapping("/pokemon")
@Tag(name = "Pokémon", description = "Operaciones para obtener información de Pokémon")
public class PokemonController {
    private final PokemonApiService pokemonApiService;

    @Autowired
    public PokemonController(PokemonApiService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    @Operation(summary = "Obtener información de un Pokémon por nombre", description = "Devuelve los datos completos del Pokémon consultado")
    @GetMapping("/{name}")
    public PokemonResponse getPokemonByName(@PathVariable String name) {
        return pokemonApiService.getPokemonByName(name);
    }
}

