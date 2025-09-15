package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement(name = "BaseExperienceRequest", namespace = "http://pokemon.com/soap")
@XmlType(name = "BaseExperienceRequest", propOrder = { "pokemonName" })
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class BaseExperienceRequest implements Serializable {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}

