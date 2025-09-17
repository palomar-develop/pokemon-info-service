package com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Getter
@Setter
public class VersionDetail implements Serializable {
    private Integer rarity;
    private Version version;
}

