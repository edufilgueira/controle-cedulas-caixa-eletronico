package com.cedula.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CedulaMovimento {
	
	@Id
	@SequenceGenerator(name = "CedulaMovimento_seq", sequenceName = "CedulaMovimento_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CedulaMovimento_seq")
	private Integer Id;
	
	@JoinColumn
	@ManyToOne
	private Cedula cedula;
	
	private Integer quantidade;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataentrada;
	
	private String tipoEntrada;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Cedula getCedula() {
		return cedula;
	}

	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	
}
