package com.palomar.pokemoninfoservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class PokemonResponse {
    private List<AbilitySlot> abilities;

    @JsonProperty("base_experience")
    private int baseExperience;
    @JsonProperty("held_items")
    private List<HeldItem> heldItems;
    private int id;
    private String name;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
}

