package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hc_factores_riesgo")
public class FactoresRiesgoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_factores")
	private Long seq_factores;

	@Column(name = "nom_empresa", length = 100)
	private String nomEmpresa;

	@Column(name = "desp_factores", length = 4000)
	private String despFactores;

	@Column(name = "tiempo")
	private String tiempo;

	@Column(name = "desp_medidas_control", length = 4000)
	private String despMedidasControl;

	public Long getSeq_factores() {
		return seq_factores;
	}

	public void setSeq_factores(Long seq_factores) {
		this.seq_factores = seq_factores;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public String getDespFactores() {
		return despFactores;
	}

	public void setDespFactores(String despFactores) {
		this.despFactores = despFactores;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getDespMedidasControl() {
		return despMedidasControl;
	}

	public void setDespMedidasControl(String despMedidasControl) {
		this.despMedidasControl = despMedidasControl;
	}

}
