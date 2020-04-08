package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hc_tipo_cuestionario")
public class TipoCuestionarioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_tipo_cuestionario")
	private Long seqTipoCuestionario;

	@Column(name = "nom_cuestionario")
	private String nomCuestionario;

	public Long getSeqTipoCuestionario() {
		return seqTipoCuestionario;
	}

	public void setSeqTipoCuestionario(Long seqTipoCuestionario) {
		this.seqTipoCuestionario = seqTipoCuestionario;
	}

	public String getNomCuestionario() {
		return nomCuestionario;
	}

	public void setNomCuestionario(String nomCuestionario) {
		this.nomCuestionario = nomCuestionario;
	}
	
	
}
