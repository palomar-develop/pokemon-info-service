package com.palomar.pokemoninfoservice.client.external.impl;

import com.palomar.pokemoninfoservice.client.external.PokemonApiClient;
import com.palomar.pokemoninfoservice.client.external.PokemonApiFeignClient;
import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import feign.FeignException;

@Component
@Qualifier("feign")
@Log4j2
public class PokemonApiFeignClientImpl implements PokemonApiClient {
    private final PokemonApiFeignClient feignClient;

    @Autowired
    public PokemonApiFeignClientImpl(PokemonApiFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public PokemonResponse getPokemonByName(String name) {
        try {
            log.info(" FEIGH Fetching Pokémon data for name: {}", name);
            return feignClient.getPokemonByName(name);

        } catch (FeignException.NotFound e) {
            throw new PokemonNotFoundException(Constants.POKEMON_NOT_FOUND_MESSAGE + name);
        }
    }
}

