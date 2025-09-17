package com.palomar.pokemoninfoservice.model.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palomar.pokemoninfoservice.domain.model.dto.AbilitiesRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbilitiesRequestSerializationTest {
    @Test
    void testSerializationAndDeserialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        AbilitiesRequest request = new AbilitiesRequest();
        request.setPokemonName("pikachu");
        String json = mapper.writeValueAsString(request);
        assertTrue(json.contains("pikachu"));
        AbilitiesRequest deserialized = mapper.readValue(json, AbilitiesRequest.class);
        assertEquals("pikachu", deserialized.getPokemonName());
    }
}

