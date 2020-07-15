package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.itinerario.ItinerarioOnibus;
import com.example.demo.services.ItinerarioOnibusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api/itinerarios/")
public class ItinerarioOnibusController {

	@Autowired
	private ItinerarioOnibusService itinerarioService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("{linha}")
	public ResponseEntity<ItinerarioOnibus> getAllLinhasOnibus(@PathVariable(value="linha") String linhaOnibus) throws JsonMappingException, JsonProcessingException {
		return this.itinerarioService.getAll(linhaOnibus);
	}
	
}
