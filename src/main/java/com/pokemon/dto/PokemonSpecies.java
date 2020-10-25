package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class PokemonSpecies {
	
	private EvolutionChain evolution_chain;

}
