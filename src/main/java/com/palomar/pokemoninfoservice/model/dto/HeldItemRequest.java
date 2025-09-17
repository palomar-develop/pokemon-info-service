package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement(name = "HeldItemRequest", namespace = "http://pokemon.com/soap")
@XmlType(name = "HeldItemRequest", propOrder = { "pokemonName" })
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class HeldItemRequest implements Serializable {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}

