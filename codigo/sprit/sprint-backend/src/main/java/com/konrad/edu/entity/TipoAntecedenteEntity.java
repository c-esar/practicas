package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_tipo_antecedente")
public class TipoAntecedenteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_tipo_antecedente")
	private Long seqTipoAntecedente;

	@Column(name = "nom_antecedente")
	private String nomAntecedente;

	public Long getSeqTipoAntecedente() {
		return seqTipoAntecedente;
	}

	public void setSeqTipoAntecedente(Long seqTipoAntecedente) {
		this.seqTipoAntecedente = seqTipoAntecedente;
	}

	public String getNomAntecedente() {
		return nomAntecedente;
	}

	public void setNomAntecedente(String nomAntecedente) {
		this.nomAntecedente = nomAntecedente;
	}

}
