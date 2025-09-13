package com.palomar.pokemoninfoservice.client.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;

@Data
@XmlRootElement(name = "AbilitySlot")
@XmlType(name = "AbilitySlot", propOrder = { "ability", "isHidden", "slot" })
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilitySlot {
    @XmlElement(name = "ability")
    private Ability ability;

    @JsonProperty("is_hidden")
    @XmlElement(name = "isHidden")
    private Boolean isHidden;
    @XmlElement(name = "slot")
    private Integer slot;
}
