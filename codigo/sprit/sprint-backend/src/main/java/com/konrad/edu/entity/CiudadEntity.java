package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_ciudad")
public class CiudadEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_ciudad", nullable = false)
	private Long seqCuidad;

	@Column(name = "cod_pais", nullable = false)
	private String codPais;

	@Column(name = "cod_dpto", nullable = false)
	private String codDpto;

	@Column(name = "cod_poblacion", nullable = false)
	private String codPoblacion;

	@Column(name = "cod_ciudad", nullable = false)
	private String codCuidad;

	@Column(name = "nom_ciudad", nullable = false)
	private String nomCuidad;

	public Long getSeqCuidad() {
		return seqCuidad;
	}

	public void setSeqCuidad(Long seqCuidad) {
		this.seqCuidad = seqCuidad;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getCodDpto() {
		return codDpto;
	}

	public void setCodDpto(String codDpto) {
		this.codDpto = codDpto;
	}

	public String getCodPoblacion() {
		return codPoblacion;
	}

	public void setCodPoblacion(String codPoblacion) {
		this.codPoblacion = codPoblacion;
	}

	public String getCodCuidad() {
		return codCuidad;
	}

	public void setCodCuidad(String codCuidad) {
		this.codCuidad = codCuidad;
	}

	public String getNomCuidad() {
		return nomCuidad;
	}

	public void setNomCuidad(String nomCuidad) {
		this.nomCuidad = nomCuidad;
	}

}
