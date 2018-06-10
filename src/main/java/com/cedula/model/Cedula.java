package com.cedula.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cedula {
	
	@Id
	@SequenceGenerator(name = "Cedula_seq", sequenceName = "Cedula_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cedula_seq")
	private Integer id;
	private String nome;
	private Integer valor;
	private Integer estoque;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public void diminuirEstoque(Integer value) {
		this.estoque = estoque - value;
	}
	

}