package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.itinerario.ItinerarioOnibus;
import com.example.demo.utils.ItinerarioEntityParser;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class PoaTransporteItinerarioRestClient {
	
	private String REQUEST_URI = "http://www.poatransporte.com.br/php/facades/process.php?a=il&p=";
	
	@Autowired
	private RestTemplate restItinerarioTemplate;
	
	public ResponseEntity<ItinerarioOnibus> getAll(String linhaOnibus) throws JsonMappingException, JsonProcessingException {
		
		ItinerarioEntityParser itinerarioParser = new ItinerarioEntityParser();
		
		ResponseEntity<String> entity = restItinerarioTemplate.getForEntity(REQUEST_URI + linhaOnibus, String.class);

		ItinerarioOnibus response = itinerarioParser.parseStringToItinerarioOnibusEntity(entity.getBody());
		
		return new ResponseEntity<ItinerarioOnibus>(response, HttpStatus.OK);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
