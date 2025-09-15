package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.client.model.AbilitySlot;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@XmlRootElement(name = "AbilitiesResponse", namespace = "http://pokemon.com/soap")
@XmlType(name = "AbilitiesResponse", propOrder = {  "abilities" })
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class AbilitiesResponse implements Serializable {

    @XmlElement(name = "abilitySlot", namespace = "http://pokemon.com/soap")
    private List<AbilitySlot> abilities;
}
