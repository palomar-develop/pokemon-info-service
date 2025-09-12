package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import lombok.Data;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@XmlRootElement(name = "TextResponse", namespace = "http://ejemplo.com/soap")
@XmlType(name = "TextResponse", propOrder = { "texto" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TextResponse {
    @XmlElement(name = "texto", namespace = "http://ejemplo.com/soap")
    private String texto;

}