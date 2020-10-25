package com.pokemon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pokemon.dto.ExceptionDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PokemonExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {PokemonFeignException.class,Exception.class})
	public final ResponseEntity handleConflict(RuntimeException ex) {
		ExceptionDto exceptionDto = new ExceptionDto();
		if (ex instanceof PokemonFeignException) {
			log.error("Error Feign",ex);
			exceptionDto.setMessage("Error al consumir PokemonAPI");
			return new ResponseEntity(exceptionDto,null, HttpStatus.BAD_REQUEST);
		}else {
			log.error("Error No Controlado",ex);
			exceptionDto.setMessage("Error interno, por favor intente mas tarde");
			return new ResponseEntity(exceptionDto,null, HttpStatus.BAD_REQUEST);
		}
	}
}
