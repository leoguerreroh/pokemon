package com.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class EvolvesTo {

	private List<EvolvesTo> evolves_to;
	private Species species;
}
