package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.taxi.PontoTaxi;
import com.example.demo.storage.PontosTaxiSingletonDataset;

@Service
public class PontoTaxiService {
		
	public ResponseEntity<Object> insertPontoTaxi(PontoTaxi entity) {
		PontosTaxiSingletonDataset instance = PontosTaxiSingletonDataset.getInstance();
		String taxiNewLineStructure = constructFileString(entity);
		
		entity.setDataInsercao(new DateTime());
		
		instance.writeDataToFile(taxiNewLineStructure);
		instance.getDataset().put(instance.getId(), entity);
		
		return ResponseEntity.ok().body(entity);
	}
	
	public Iterable<PontoTaxi> getAllPontosTaxi() {
		List<PontoTaxi> allPontosTaxi = new ArrayList<>();
		Map<Integer, PontoTaxi> datasetMemoryStructure = PontosTaxiSingletonDataset.getInstance().getDataset();
		
		for(PontoTaxi ponto : datasetMemoryStructure.values()) {
			allPontosTaxi.add(ponto);
		}
		
		return allPontosTaxi;
	}
	
	public PontoTaxi getPontoTaxiByName(String namePontoTaxi) {
		
		PontosTaxiSingletonDataset instance = PontosTaxiSingletonDataset.getInstance();
		Map<Integer, PontoTaxi> dataset = instance.getDataset();
		
		for (PontoTaxi ponto : dataset.values()) {
			if (ponto.getNome().equalsIgnoreCase(namePontoTaxi)) {
				return ponto;
			}
		}
		
		return null;		
	}
	
	private String constructFileString(PontoTaxi entity) {
		return entity.getNome() + "#" + entity.getLat() + "#" + entity.getLng() + "#" + new LocalDateTime().toString() + "\n";
	}

}
