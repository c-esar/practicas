package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private Long seqlocalidad;

	@Column(name = "nom_localidad", nullable = false)
	private String nomLocalidad;

	public Long getSeqlocalidad() {
		return seqlocalidad;
	}

	public void setSeqlocalidad(Long seqlocalidad) {
		this.seqlocalidad = seqlocalidad;
	}

	public String getNomLocalidad() {
		return nomLocalidad;
	}

	public void setNomLocalidad(String nomLocalidad) {
		this.nomLocalidad = nomLocalidad;
	}

	

}
