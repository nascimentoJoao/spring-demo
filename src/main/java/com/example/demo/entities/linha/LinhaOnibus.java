package com.example.demo.entities.linha;

public class LinhaOnibus {
	
	private String id;
	
	private String codigo;
	
	private String nome;
	
	public LinhaOnibus() { }
	
	public LinhaOnibus(String id, String codigo, String nome) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	

}
