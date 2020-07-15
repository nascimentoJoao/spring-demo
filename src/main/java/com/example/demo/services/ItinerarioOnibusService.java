package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.PoaTransporteItinerarioRestClient;
import com.example.demo.entities.itinerario.ItinerarioOnibus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ItinerarioOnibusService {

	@Autowired
	private PoaTransporteItinerarioRestClient itinerarioRestTemplate;
	
	public ResponseEntity<ItinerarioOnibus> getAll(String linhaOnibus) throws JsonMappingException, JsonProcessingException {
		return this.itinerarioRestTemplate.getAll(linhaOnibus);
	}
	
}
