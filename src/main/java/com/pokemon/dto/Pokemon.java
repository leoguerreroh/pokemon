package com.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Pokemon {
	
	private Integer id;
	private String name;
	private Double weight;
	private List<Abilities> abilities;
	private List<Types> types;

	
}
