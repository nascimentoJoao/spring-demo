package com.example.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.linha.LinhaOnibus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PoaTransporteLinhaRestClient {

	private String REQUEST_URI = "http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o";
	
	@Autowired
	private RestTemplate restLinhaTemplate;
	
	public ResponseEntity<List<LinhaOnibus>> getAll() throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> entity = restLinhaTemplate.getForEntity(REQUEST_URI, String.class);
		
		String entityResponse = entity.getBody();
		
		List<LinhaOnibus> response = new ObjectMapper().readValue(entityResponse, new TypeReference<List<LinhaOnibus>>() {});
		
		return new ResponseEntity<List<LinhaOnibus>>(response, HttpStatus.OK);
	}
		
}
