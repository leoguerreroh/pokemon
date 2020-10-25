package com.pokemon.service;

import java.net.URI;
import java.util.List;

import com.pokemon.dto.Descriptions;
import com.pokemon.dto.Evolutions;
import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonForms;
import com.pokemon.dto.PokemonSpecies;
import com.pokemon.dto.Species;

public interface PokemonService {

	Pokemon getPokemonByName(String name);
	
	Descriptions getDescriptionById(Integer id);
	
	Evolutions getEvolutionsById(URI uri);
	
	PokemonSpecies getSpeciesById(Integer id);
	
	PokemonForms getImageById(Integer id);
	
	List<Species> getAllPokemon();
}
