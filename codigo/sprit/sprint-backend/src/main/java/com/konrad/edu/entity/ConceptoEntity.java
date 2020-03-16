package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_concepto")
public class ConceptoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_concepto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqConcepto;

	@Column(name = "nom_concepto")
	private String nomConcepto;

	@Column(name = "tipo_concepto")
	private String tipoConcepto;

	public Long getSeqConcepto() {
		return seqConcepto;
	}

	public void setSeqConcepto(Long seqConcepto) {
		this.seqConcepto = seqConcepto;
	}

	public String getNomConcepto() {
		return nomConcepto;
	}

	public void setNomConcepto(String nomConcepto) {
		this.nomConcepto = nomConcepto;
	}

	public String getTipoConcepto() {
		return tipoConcepto;
	}

	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

}
