package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.linha.LinhaOnibus;
import com.example.demo.services.LinhaOnibusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api/linhas")
public class LinhaOnibusController {
	
	@Autowired
	private LinhaOnibusService linhaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinhaOnibus>> getAllLinhasOnibus() throws JsonMappingException, JsonProcessingException {
		return this.linhaService.getAll();
	}
	
}
