package com.pokemon.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pokemon.config.CacheConfig;
import com.pokemon.dto.Descriptions;
import com.pokemon.dto.Evolutions;
import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonForms;
import com.pokemon.dto.PokemonSpecies;
import com.pokemon.dto.Species;
import com.pokemon.feign.PokemonFeign;
import com.pokemon.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonFeign pokemonFeign;
	
	@Override
	@Cacheable(value = CacheConfig.POKEMON_BY_NAME, key = "#name", unless = "#result == null")
	public Pokemon getPokemonByName(String name) {
		return pokemonFeign.getPokemonByName(name);
	}

	@Override
	@Cacheable(value = CacheConfig.DESCRIPTION_BY_ID, key = "#id", unless = "#result == null")
	public Descriptions getDescriptionById(Integer id) {
		return pokemonFeign.getDescriptionById(id);
	}

	@Override
	@Cacheable(value = CacheConfig.EVOLUTIONS_BY_ID, key = "#uri", unless = "#result == null")
	public Evolutions getEvolutionsById(URI uri) {
		return pokemonFeign.getEvolutionById(uri);
	}

	@Override
	@Cacheable(value = CacheConfig.SPECIES_BY_ID, key = "#id", unless = "#result == null")
	public PokemonSpecies getSpeciesById(Integer id) {
		return pokemonFeign.getSpeciesById(id);
	}

	@Override
	@Cacheable(value = CacheConfig.IMAGE_BY_ID, key = "#id", unless = "#result == null")
	public PokemonForms getImageById(Integer id) {
		return pokemonFeign.getImageById(id);
	}

	@Override
	@Cacheable(value = CacheConfig.GET_POKEMON, unless = "#result == null")
	public List<Species> getAllPokemon() {
		return pokemonFeign.getAllPokemon().getResults();
	}
	

}
