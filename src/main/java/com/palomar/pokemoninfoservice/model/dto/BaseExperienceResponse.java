package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@XmlRootElement(name = "BaseExperienceResponse", namespace = "http://pokemon.com/soap")
@XmlType(name = "BaseExperienceResponse", propOrder = { "baseExperience" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BaseExperienceResponse {
    @XmlElement(name = "baseExperience", namespace = "http://pokemon.com/soap")
    private Integer baseExperience;
}

