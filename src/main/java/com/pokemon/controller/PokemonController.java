package com.pokemon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.delegate.PokemonDelegate;
import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonResponse;
import com.pokemon.dto.Species;

@RestController
@RequestMapping("/api")
public class PokemonController {
	
	@Autowired
	private PokemonDelegate pokemonDelegate;
	
	@GetMapping("/info-pokemon/{name}")
	public ResponseEntity<PokemonResponse> getPokemon(@PathVariable("name") String name){
		return pokemonDelegate.getInfoPokemon(name);
	} 
	
	@GetMapping("/get-pokemons")
	public ResponseEntity<List<Species>> getAllPokemon(){
		return pokemonDelegate.getAllPokemon();
	}
	
}

