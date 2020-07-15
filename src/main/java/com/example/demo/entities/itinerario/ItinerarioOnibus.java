package com.example.demo.entities.itinerario;

import java.util.Map;

public class ItinerarioOnibus {

	private String idlinha;
	
	private String codigo;
	
	private String nome;
	
	private Map<String, CoordenadasItinerario> coordenadas;

	public String getIdlinha() {
		return idlinha;
	}

	public void setIdlinha(String idlinha) {
		this.idlinha = idlinha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, CoordenadasItinerario> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Map<String, CoordenadasItinerario> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
}

