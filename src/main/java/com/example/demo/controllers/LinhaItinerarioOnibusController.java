package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.linhaitinerario.LinhaItinerarioOnibus;
import com.example.demo.exception.LinhaItinerarioNotFoundException;
import com.example.demo.services.LinhaItinerarioOnibusService;

@RestController
@RequestMapping("/api/linha/itinerario/")
public class LinhaItinerarioOnibusController {
	
	@Autowired
	private LinhaItinerarioOnibusService linhaItinerarioService;
	
	@DeleteMapping("{id}")
	public Boolean deleteLinhaItinerario(@PathVariable(value="id") Long id) {
		return this.linhaItinerarioService.deleteLinhaItinerario(id);
	}
	
	@GetMapping
	public Iterable<LinhaItinerarioOnibus> getAllLinhaItinerarioInstances() {
		return this.linhaItinerarioService.getAllLinhaItinerarioInstances();
	}
	
	@GetMapping("{id}")
	public LinhaItinerarioOnibus getLinhaItinerarioById(@PathVariable(value="id") Long id) throws LinhaItinerarioNotFoundException
	{	
		return this.linhaItinerarioService.getLinhaItinerarioById(id);
	}
	
	@PostMapping
	public LinhaItinerarioOnibus insertNewLinhaItinerario(@RequestBody LinhaItinerarioOnibus entity) {
		return this.linhaItinerarioService.insertNewLinhaItinerario(entity);
	}
	
}
