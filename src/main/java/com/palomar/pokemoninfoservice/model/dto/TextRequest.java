package com.palomar.pokemoninfoservice.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@XmlRootElement(name = "TextRequest", namespace = "http://ejemplo.com/soap")
@XmlType(name = "TextRequest", propOrder = { "texto" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TextRequest {
    @XmlElement(name = "texto", namespace = "http://ejemplo.com/soap")
    private String texto;

}
