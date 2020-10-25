package com.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class PokemonResponse {
	
	private Integer id;
	private String name;
	private Double weight;
	private String description;
	private String image;
	private List<String> abilities;
	private List<String> types;
	private List<String> evolutions;
	
	
}
