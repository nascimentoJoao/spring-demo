package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LinhaItinerario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String codigo;
	
	private String nome;
	
	private String lat;
	
	private String lng;
	
	public LinhaItinerario() { }

	public LinhaItinerario(Long id, String codigo, String nome, String lat, String lng) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.lat = lat;
		this.lng = lng;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
}
