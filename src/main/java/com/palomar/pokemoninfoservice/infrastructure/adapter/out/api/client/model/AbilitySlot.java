package com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Setter
@Getter
@XmlRootElement(name = "AbilitySlot")
@XmlType(name = "AbilitySlot", propOrder = { "ability", "isHidden", "slot" })
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilitySlot implements Serializable {
    @XmlElement(name = "ability")
    private Ability ability;

    @JsonProperty("is_hidden")
    @XmlElement(name = "isHidden")
    private Boolean isHidden;
    @XmlElement(name = "slot")
    private Integer slot;
}
