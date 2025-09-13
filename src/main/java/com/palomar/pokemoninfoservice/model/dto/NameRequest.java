package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlRootElement(name = "NameRequest", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class NameRequest {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}

