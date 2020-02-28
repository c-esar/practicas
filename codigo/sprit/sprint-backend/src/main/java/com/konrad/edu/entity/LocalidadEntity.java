package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hc_localidad")
public class LocalidadEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_localidad", nullable = false)
	private Long seqLocalidad;

	@Column(name = "cod_localidad", nullable = false, unique = true)
	private String codLocalidad;

	@Column(name = "nom_localidad", nullable = false)
	private String nomLocalidad;

	public Long getSeqLocalidad() {
		return seqLocalidad;
	}

	public void setSeqLocalidad(Long seqLocalidad) {
		this.seqLocalidad = seqLocalidad;
	}

	public String getCodLocalidad() {
		return codLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public String getNomLocalidad() {
		return nomLocalidad;
	}

	public void setNomLocalidad(String nomLocalidad) {
		this.nomLocalidad = nomLocalidad;
	}

}
