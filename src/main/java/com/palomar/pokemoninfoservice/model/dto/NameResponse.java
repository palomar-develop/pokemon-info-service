package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlRootElement(name = "NameResponse", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class NameResponse {
    @XmlElement(name = "name", namespace = "http://pokemon.com/soap")
    private String name;
}

