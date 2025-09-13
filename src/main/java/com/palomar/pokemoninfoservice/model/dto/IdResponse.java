package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlRootElement(name = "IdResponse", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class IdResponse {
    @XmlElement(name = "id", namespace = "http://pokemon.com/soap")
    private Integer id;
}

