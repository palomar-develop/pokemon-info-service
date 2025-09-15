package com.palomar.pokemoninfoservice.model.dto;

import com.palomar.pokemoninfoservice.client.model.HeldItem;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "HeldItemResponse", namespace = "http://pokemon.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class HeldItemResponse implements Serializable {
    @XmlElement(name = "heldItem", namespace = "http://pokemon.com/soap")
    private List<HeldItem> heldItem;
}

