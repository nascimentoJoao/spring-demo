package com.example.demo.entities.taxi;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PontoTaxi {
	
	private String nome;
	
	private String lat;
	
	private String lng;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]X")
	private DateTime dataInsercao;
	
	public PontoTaxi() {
	
	}

	public PontoTaxi(String nome, String lat, String lng, DateTime dataInsercao) {
		super();
		this.nome = nome;
		this.lat = lat;
		this.lng = lng;
		this.dataInsercao = dataInsercao;
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

	public DateTime getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(DateTime dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

}
