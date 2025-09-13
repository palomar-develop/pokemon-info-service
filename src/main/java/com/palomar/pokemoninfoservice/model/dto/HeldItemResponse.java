package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import com.palomar.pokemoninfoservice.client.model.HeldItem;
import java.util.List;

@XmlRootElement(name = "HeldItemResponse", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class HeldItemResponse {
    @XmlElement(name = "heldItem", namespace = "http://pokemon.com/soap")
    private List<HeldItem> heldItem;
}

