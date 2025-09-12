package com.palomar.pokemoninfoservice.client.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AbilitySlot {
    private Ability ability;
    @JsonProperty("is_hidden")
    private boolean isHidden;
    private int slot;
}
