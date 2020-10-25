package com.pokemon.feign;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pokemon.dto.Descriptions;
import com.pokemon.dto.Evolutions;
import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonForms;
import com.pokemon.dto.PokemonSpecies;
import com.pokemon.dto.Pokemons;

@FeignClient(url="${feign.endpoint.main}", name = "PokemonAPI")
public interface PokemonFeign {

	@GetMapping("pokemon/{name}/")
	public Pokemon getPokemonByName(@PathVariable("name") String name);
	
	@GetMapping("characteristic/{id}/")
	public Descriptions getDescriptionById(@PathVariable("id") Integer id);
	
	@GetMapping()
	public Evolutions getEvolutionById(URI baseUrl);
	
	@GetMapping("pokemon-species/{id}/")
	public PokemonSpecies getSpeciesById(@PathVariable("id") Integer id);
	
	@GetMapping("pokemon-form/{id}/")
	public PokemonForms getImageById(@PathVariable("id") Integer id);
	
	@GetMapping("pokemon?limit=20")
	public Pokemons getAllPokemon();
	
}
