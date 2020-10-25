package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Description {
	
	private String description;
	private Language language;

}
