package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.PoaTransporteLinhaRestClient;
import com.example.demo.entities.linha.LinhaOnibus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class LinhaOnibusService {
	
	@Autowired
	private PoaTransporteLinhaRestClient linhaRestTemplate;
	
	public ResponseEntity<List<LinhaOnibus>> getAll() throws JsonMappingException, JsonProcessingException {
		return this.linhaRestTemplate.getAll();
	}
	
	
}
