package com.pokemon;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pokemon.controller.PokemonController;
import com.pokemon.delegate.impl.PokemonDelegateImpl;

import static org.mockito.ArgumentMatchers.*;

@AutoConfigureMockMvc(addFilters=false)
@ContextConfiguration(classes ={PokemonController.class})
@WebMvcTest
public class PokemonControllerTest {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private PokemonDelegateImpl pokemonDelegate;
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Test
	public void getInfoPokemon()  throws Exception  {
		when(pokemonDelegate.getInfoPokemon(any())).thenReturn(ResponseEntity.ok(null));
		mvc.perform(
                get("/api/info-pokemon/ivysaur")
                                        .contentType(APPLICATION_JSON_UTF8)
                ).andExpect(status().isOk());
		
	}
	
	@Test
	public void getAllPokemon()  throws Exception  {
		when(pokemonDelegate.getAllPokemon()).thenReturn(ResponseEntity.ok(null));
		mvc.perform(
                get("/api/get-pokemons")
                                        .contentType(APPLICATION_JSON_UTF8)
                ).andExpect(status().isOk());
		
	}
}
