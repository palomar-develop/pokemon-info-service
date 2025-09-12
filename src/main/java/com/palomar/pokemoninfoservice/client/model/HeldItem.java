package com.palomar.pokemoninfoservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class HeldItem {
    private Item item;
    @JsonProperty("version_details")
    private List<VersionDetail> versionDetails;
}
