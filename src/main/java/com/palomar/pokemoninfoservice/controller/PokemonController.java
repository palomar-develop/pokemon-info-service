package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.service.PokeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@Tag(name = "Pokémon", description = "Operaciones para obtener información de Pokémon")
public class PokemonController {
    private final PokeApiService pokeApiService;

    @Autowired
    public PokemonController(PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    @Operation(summary = "Obtener información de un Pokémon por nombre", description = "Devuelve los datos completos del Pokémon consultado")
    @GetMapping("/{name}")
    public PokemonResponse getPokemonByName(@PathVariable String name) {
        return pokeApiService.getPokemonByName(name);
    }
}

