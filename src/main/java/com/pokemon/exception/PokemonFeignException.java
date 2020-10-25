package com.pokemon.exception;

import feign.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PokemonFeignException extends RuntimeException {

	private String methodKey;
	private Response response;

}
