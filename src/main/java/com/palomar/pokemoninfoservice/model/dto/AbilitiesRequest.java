package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@XmlRootElement(name = "AbilitiesRequest", namespace = "http://pokemon.com/soap")
@XmlType(name = "AbilitiesRequest", propOrder = { "pokemonName" })
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class AbilitiesRequest implements Serializable {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;

}
