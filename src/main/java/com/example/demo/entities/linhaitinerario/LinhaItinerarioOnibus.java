package com.example.demo.entities.linhaitinerario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.entities.itinerario.CoordenadasItinerario;

@Entity
public class LinhaItinerarioOnibus {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String codigo;
	
	private String nome;
	
	@OneToMany(mappedBy = "linhaItinerario")
	private List<CoordenadasItinerario> itinerario;
	
	public LinhaItinerarioOnibus() { }

	public LinhaItinerarioOnibus(Long id, String codigo, String nome) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
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

	public List<CoordenadasItinerario> getItinerario() {
		return itinerario;
	}

	public void setItinerario(List<CoordenadasItinerario> itinerario) {
		this.itinerario = itinerario;
	}
	
}
