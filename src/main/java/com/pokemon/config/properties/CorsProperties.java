package com.pokemon.config.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {
	
	private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private List<String> allowedOrigins;
    private String pathCors;
    
}
