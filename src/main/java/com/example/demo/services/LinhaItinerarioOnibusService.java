package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.itinerario.CoordenadasItinerario;
import com.example.demo.entities.linhaitinerario.LinhaItinerarioOnibus;
import com.example.demo.exception.LinhaItinerarioNotFoundException;
import com.example.demo.repositories.LinhaItinerarioOnibusRepository;

@Service
public class LinhaItinerarioOnibusService {
	
	@Autowired
	private LinhaItinerarioOnibusRepository linhaItinerarioRepository;
	
	public LinhaItinerarioOnibus insertNewLinhaItinerario(LinhaItinerarioOnibus entity) {
		List<CoordenadasItinerario> coordenadas = entity.getItinerario();
		
		LinhaItinerarioOnibus linhaItinerario = new LinhaItinerarioOnibus();
		linhaItinerario.setItinerario(coordenadas);
		linhaItinerario.setCodigo(entity.getCodigo());
		linhaItinerario.setNome(entity.getNome());
		
		return this.linhaItinerarioRepository.save(linhaItinerario);
	}
	
	public Boolean deleteLinhaItinerario(Long id) {
		LinhaItinerarioOnibus linhaItinerario = this.linhaItinerarioRepository.findById(id).get();
		if (linhaItinerario != null) {
			this.linhaItinerarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public LinhaItinerarioOnibus getLinhaItinerarioById(Long id) {
		if(this.linhaItinerarioRepository.findById(id).isPresent()) {
			return this.linhaItinerarioRepository.findById(id).get();
		} else {
			throw new LinhaItinerarioNotFoundException(id);
		}
	}
	
	public Iterable<LinhaItinerarioOnibus> getAllLinhaItinerarioInstances() {
		return this.linhaItinerarioRepository.findAll();
	}

}
