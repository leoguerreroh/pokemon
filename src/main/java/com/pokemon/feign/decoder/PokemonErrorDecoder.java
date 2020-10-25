package com.pokemon.feign.decoder;

import com.pokemon.exception.PokemonFeignException;

import feign.Response;
import feign.codec.ErrorDecoder;


public class PokemonErrorDecoder implements ErrorDecoder {

	@Override
    public PokemonFeignException decode(String methodKey, Response response) {
        return new PokemonFeignException(methodKey,response);
    }
}
