package com.palomar.pokemoninfoservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Getter
@Setter
public class PokemonResponse implements Serializable {
    private List<AbilitySlot> abilities;

    @JsonProperty("base_experience")
    private Integer baseExperience;
    @JsonProperty("held_items")
    private List<HeldItem> heldItems;
    private Integer id;
    private String name;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
}
