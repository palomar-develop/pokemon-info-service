package com.palomar.pokemoninfoservice.client.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Getter
@Setter
public class Version implements Serializable {
    private String name;
    private String url;
}

