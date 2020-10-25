package com.pokemon.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
	
	public static final String POKEMON_BY_NAME = "POKEMON_BY_NAME";
	public static final String DESCRIPTION_BY_ID = "DESCRIPTION_BY_ID";
	public static final String EVOLUTIONS_BY_ID = "EVOLUTIONS_BY_ID";
	public static final String SPECIES_BY_ID = "SPECIES_BY_ID";
	public static final String IMAGE_BY_ID = "IMAGE_BY_ID";
	public static final String GET_POKEMON = "GET_POKEMON";
	
	@Value("${cache.minutes}")
	private int minutes;
	
	@Bean
    public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		
        CaffeineCache cachePokemonById = new CaffeineCache(POKEMON_BY_NAME, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        CaffeineCache cacheDescriptionById = new CaffeineCache(DESCRIPTION_BY_ID, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        CaffeineCache cacheEvolutionsById = new CaffeineCache(EVOLUTIONS_BY_ID, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        CaffeineCache cacheSpeciesById = new CaffeineCache(SPECIES_BY_ID, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        CaffeineCache cacheImageById = new CaffeineCache(IMAGE_BY_ID, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        CaffeineCache cacheGetPokemons = new CaffeineCache(GET_POKEMON, Caffeine.newBuilder()
                .expireAfterWrite(minutes, TimeUnit.MINUTES)
                .build());
        
        
        simpleCacheManager.setCaches(Arrays.asList(cachePokemonById,cacheDescriptionById,cacheEvolutionsById,cacheSpeciesById,cacheImageById,cacheGetPokemons));
        return simpleCacheManager;
	}
}
