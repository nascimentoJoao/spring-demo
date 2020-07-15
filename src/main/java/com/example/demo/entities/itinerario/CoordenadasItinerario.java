package com.example.demo.entities.itinerario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entities.linhaitinerario.LinhaItinerarioOnibus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CoordenadasItinerario {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	private String lat;
	
	private String lng;
	
	@ManyToOne
	@JoinColumn(name = "coord_linhaItinerario")
	@JsonIgnore
	private LinhaItinerarioOnibus linhaItinerario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LinhaItinerarioOnibus getLinhaItinerario() {
		return linhaItinerario;
	}

	public void setLinhaItinerario(LinhaItinerarioOnibus linhaItinerario) {
		this.linhaItinerario = linhaItinerario;
	}
	
}
