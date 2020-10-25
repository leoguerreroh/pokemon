package com.pokemon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pokemon.feign.decoder.PokemonErrorDecoder;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignConfig implements RequestInterceptor {
	
    @Value("${feign.client.config.default.readTimeout}")
    private int readTimeout;

    @Value("${feign.client.config.default.connectTimeout}")
    private int connectionTimeout;
	
    @Bean
    public PokemonErrorDecoder errorDecoder() {
        return new PokemonErrorDecoder();
    }

	@Override
	public void apply(RequestTemplate template) {
		template.header("User-Agent", "cheese");
	}
    
	@Bean
    public Request.Options requestOptions() {
        return new Request.Options(connectionTimeout, readTimeout);
    }
}
