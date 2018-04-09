package com.luiz.Entity;
public class Pais {

	private Integer idPais;
	private String nome;


	public Pais(Integer idPais, String nome) {
		this.idPais = idPais;
		this.nome = nome;
	}

	public Pais(String nome) {
		this.nome = nome;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	 public String toString() {
	    	return "ID - " + idPais + "             Nome - " + nome + ";\n";
	 }

}