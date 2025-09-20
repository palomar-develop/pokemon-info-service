package com.palomar.pokemoninfoservice.client.external;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Autor: josue.palomar
 * Fecha de creación: 19/09/25
 */
@FeignClient(name = "pokemonApi", url = "${pokeapi.base-url}")
public interface PokemonApiFeignClient {
    @GetMapping("/{name}")
    PokemonResponse getPokemonByName(@PathVariable("name") String name);
}