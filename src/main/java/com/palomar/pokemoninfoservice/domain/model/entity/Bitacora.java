package com.palomar.pokemoninfoservice.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ip_origen")
    private String ipOrigen;

    @JsonProperty("fecha_request")
    private LocalDateTime fechaRequest;

    private String metodo;

    @Column(columnDefinition = "TEXT")
    private String request;

    @JsonProperty("tiempo_peticion")
    private Long tiempoPeticion;

    @Column(columnDefinition = "TEXT")
    private String response;
}
