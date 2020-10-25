package com.pokemon.delegate;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonResponse;
import com.pokemon.dto.Species;

public interface PokemonDelegate {
	
	ResponseEntity<PokemonResponse> getInfoPokemon(String name);
	
	ResponseEntity<List<Species>> getAllPokemon();

}
