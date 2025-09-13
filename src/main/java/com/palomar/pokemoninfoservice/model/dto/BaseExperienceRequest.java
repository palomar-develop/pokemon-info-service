package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@XmlRootElement(name = "BaseExperienceRequest", namespace = "http://pokemon.com/soap")
@XmlType(name = "BaseExperienceRequest", propOrder = { "pokemonName" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BaseExperienceRequest {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}

