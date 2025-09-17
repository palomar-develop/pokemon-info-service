package com.palomar.pokemoninfoservice.infrastructure.adapter.out.api.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Getter
@Setter
public class HeldItem implements Serializable {
    private Item item;
    @JsonProperty("version_details")
    private List<VersionDetail> versionDetails;
}
