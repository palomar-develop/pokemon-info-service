package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import com.palomar.pokemoninfoservice.client.model.AbilitySlot;
import java.util.List;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@XmlRootElement(name = "AbilitiesResponse", namespace = "http://pokemon.com/soap")
@XmlType(name = "AbilitiesResponse", propOrder = {  "abilities" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AbilitiesResponse {

    @XmlElement(name = "abilitySlot", namespace = "http://pokemon.com/soap")
    private List<AbilitySlot> abilities;
}
