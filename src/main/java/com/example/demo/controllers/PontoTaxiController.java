package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.taxi.PontoTaxi;
import com.example.demo.services.PontoTaxiService;

@RestController
@RequestMapping("/api/taxi/")
public class PontoTaxiController {

	@Autowired
	private PontoTaxiService pontoTaxiService;
	
	@GetMapping("{name}")
	public ResponseEntity<Object> getPontoTaxiByName(@PathVariable(value = "name") String pontoTaxiName) {
		PontoTaxi pontoTaxi =  this.pontoTaxiService.getPontoTaxiByName(pontoTaxiName);
		
		return ResponseEntity.ok().body(pontoTaxi);
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllPontosTaxi() {
		Iterable<PontoTaxi> allPontosTaxi = this.pontoTaxiService.getAllPontosTaxi();
		
		return ResponseEntity.ok().body(allPontosTaxi);
	}
	
	@PostMapping
	public void insertPontoTaxi(@RequestBody PontoTaxi entity) {		
		 this.pontoTaxiService.insertPontoTaxi(entity);
	}
	
}
