package com.palomar.pokemoninfoservice.domain.model.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement(name = "IdRequest", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class IdRequest implements Serializable {
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/soap")
    private String pokemonName;
}
