package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@XmlRootElement(name = "HeldItemRequest", namespace = "http://pokemon.com/soap")
@XmlType(name = "HeldItemRequest", propOrder = { "pokemonName" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class HeldItemRequest {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}

