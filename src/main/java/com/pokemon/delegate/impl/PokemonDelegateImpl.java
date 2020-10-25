package com.pokemon.delegate.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pokemon.delegate.PokemonDelegate;
import com.pokemon.dto.Chain;
import com.pokemon.dto.Description;
import com.pokemon.dto.Descriptions;
import com.pokemon.dto.Evolutions;
import com.pokemon.dto.Pokemon;
import com.pokemon.dto.PokemonResponse;
import com.pokemon.dto.Species;
import com.pokemon.service.PokemonService;

@Service
public class PokemonDelegateImpl implements PokemonDelegate {
	
	@Autowired
	private PokemonService pokemonService;
	
	@Override
	public ResponseEntity<List<Species>> getAllPokemon() {
		List<Species> pokemons = pokemonService.getAllPokemon();
		return ResponseEntity.ok(pokemons);
	}

	@Override
	public ResponseEntity<PokemonResponse> getInfoPokemon(String name) {
		
		Pokemon pokemon= pokemonService.getPokemonByName(name);
		
		Descriptions descriptions = pokemonService.getDescriptionById(pokemon.getId());
		Description description = descriptions.getDescriptions().stream()
				.filter(d -> d.getLanguage().getName().equalsIgnoreCase("es")).findFirst().get();		
		
		String uri = pokemonService.getSpeciesById(pokemon.getId()).getEvolution_chain().getUrl();
		Chain evolutionsChain = null;
		try {
			Evolutions evolutions = pokemonService.getEvolutionsById(new URI(uri));
			evolutionsChain = evolutions.getChain();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String urlImage = pokemonService.getImageById(pokemon.getId()).getSprites().getFrontDefault();
		
		PokemonResponse pokemonResponse = mergedPokemonResponse(pokemon,description,evolutionsChain,urlImage);
		
		return ResponseEntity.ok(pokemonResponse);
	}
	
	private PokemonResponse mergedPokemonResponse(Pokemon pokemon,Description description,Chain evolutionsChain,String urlImage) {
		PokemonResponse pokemonResponse = new PokemonResponse();
		pokemonResponse.setId(pokemon.getId());
		pokemonResponse.setName(pokemon.getName());
		pokemonResponse.setWeight(pokemon.getWeight());
		pokemonResponse.setDescription(description.getDescription());
		pokemonResponse.setImage(urlImage);
		if(pokemon.getAbilities() != null) {
			List<String> abilities = pokemon.getAbilities().stream()
										.map(a-> a.getAbility().getName())
										.collect(Collectors.toList());
			pokemonResponse.setAbilities(abilities);
		}
		if(pokemon.getTypes() != null) {
			List<String> types = pokemon.getTypes().stream()
					.map(a-> a.getType().getName())
					.collect(Collectors.toList());
			pokemonResponse.setTypes(types);
		}
		if(evolutionsChain != null) {
			List<String> evolutions = evolutionsChain.getEvolves_to().stream()
					.map(e->e.getSpecies().getName())
					.collect(Collectors.toList());
			pokemonResponse.setEvolutions(evolutions);
		}
		return pokemonResponse;
	}

}
