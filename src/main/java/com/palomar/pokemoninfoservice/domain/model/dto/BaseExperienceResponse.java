package com.palomar.pokemoninfoservice.domain.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement(name = "BaseExperienceResponse", namespace = "http://pokemon.com/soap")
@XmlType(name = "BaseExperienceResponse", propOrder = { "baseExperience" })
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class BaseExperienceResponse implements Serializable {
    @XmlElement(name = "baseExperience", namespace = "http://pokemon.com/soap")
    private Integer baseExperience;
}


