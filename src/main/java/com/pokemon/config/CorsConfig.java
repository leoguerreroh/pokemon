package com.pokemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.pokemon.config.properties.CorsProperties;

@Configuration
public class CorsConfig {
	
	@Autowired
	private CorsProperties corsProperties;
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        corsProperties.getAllowedOrigins().forEach(config::addAllowedOrigin);
        corsProperties.getAllowedHeaders().forEach(config::addAllowedHeader);
        corsProperties.getAllowedMethods().forEach(config::addAllowedMethod);
        config.setAllowCredentials(true);
        source.registerCorsConfiguration(corsProperties.getPathCors(), config);
        return new CorsFilter(source);
    }

}
