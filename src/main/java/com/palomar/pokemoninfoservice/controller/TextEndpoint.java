package com.palomar.pokemoninfoservice.controller;

import com.palomar.pokemoninfoservice.model.dto.TextRequest;
import com.palomar.pokemoninfoservice.model.dto.TextResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@Endpoint
public class TextEndpoint {

    private static final String NAMESPACE_URI = "http://ejemplo.com/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TextRequest")
    @ResponsePayload
    public TextResponse handleText(@RequestPayload TextRequest request) {
        TextResponse response = new TextResponse();
        response.setTexto("Recibido: " + request.getTexto());
        return response;
    }
}
