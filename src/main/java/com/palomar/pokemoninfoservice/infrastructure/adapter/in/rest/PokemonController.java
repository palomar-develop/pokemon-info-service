package com.palomar.pokemoninfoservice.infrastructure.adapter.in.rest;

import com.palomar.pokemoninfoservice.domain.model.dto.*;

import com.palomar.pokemoninfoservice.domain.port.in.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@RestController
@RequestMapping("/v1/pokemon")
@Tag(name = "Pokémon", description = "Operaciones para obtener información de Pokémon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    @Operation(summary = "Obtener habilidades de un Pokémon", description = "Devuelve las habilidades del Pokémon consultado")
    @GetMapping("/{pokemonName}/abilities")
    public ResponseEntity<AbilitiesResponse> getAbilities(@PathVariable String pokemonName) {
        AbilitiesResponse abilitiesResponse = pokemonService.getAbilities(pokemonName);
        return ResponseEntity.ok(abilitiesResponse);
    }

    @Operation(summary = "Obtener experiencia base de un Pokémon", description = "Devuelve la experiencia base del Pokémon consultado")
    @GetMapping("/{pokemonName}/base-experience")
    public ResponseEntity<BaseExperienceResponse> getBaseExperience(@PathVariable String pokemonName) {
        BaseExperienceResponse baseExperienceResponse = pokemonService.getBaseExperience(pokemonName);
        return ResponseEntity.ok(baseExperienceResponse);
    }

    @Operation(summary = "Obtener objetos que sostiene un Pokémon", description = "Devuelve los objetos que sostiene el Pokémon consultado")
    @GetMapping("/{pokemonName}/held-items")
    public ResponseEntity<HeldItemResponse> getHeldItem(@PathVariable String pokemonName) {
        return ResponseEntity.ok(pokemonService.getHeldItem(pokemonName));
    }

    @Operation(summary = "Obtener áreas de encuentro de un Pokémon", description = "Devuelve las áreas de encuentro del Pokémon consultado")
    @GetMapping("/{pokemonName}/location-area-encounters")
    public ResponseEntity<LocationAreaEncountersResponse> getLocationAreaEncounters(@PathVariable String pokemonName) {
        LocationAreaEncountersResponse response = pokemonService.getLocationAreaEncounters(pokemonName);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener nombre de un Pokémon", description = "Devuelve el nombre del Pokémon consultado")
    @GetMapping("/{pokemonName}/name")
    public ResponseEntity<NameResponse> getName(@PathVariable String pokemonName) {
        NameResponse nameResponse = pokemonService.getName(pokemonName);
        return ResponseEntity.ok(nameResponse);
    }

    @Operation(summary = "Obtener ID de un Pokémon", description = "Devuelve el ID del Pokémon consultado")
    @GetMapping("/{pokemonName}/id")
    public ResponseEntity<IdResponse> getId(@PathVariable String pokemonName) {
        IdResponse idResponse = pokemonService.getId(pokemonName);
        return ResponseEntity.ok(idResponse);
    }
}
