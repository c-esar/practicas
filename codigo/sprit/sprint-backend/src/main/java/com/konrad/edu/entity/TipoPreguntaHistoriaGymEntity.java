package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_tipo_pregunta_historia_gym")
public class TipoPreguntaHistoriaGymEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_tipo_pregunta")
	private Long seqTipoPregunta;

	@Column(name = "nom_pregunta")
	private String nomPregunta;

	public Long getSeqTipoPregunta() {
		return seqTipoPregunta;
	}

	public void setSeqTipoPregunta(Long seqTipoPregunta) {
		this.seqTipoPregunta = seqTipoPregunta;
	}

	public String getNomPregunta() {
		return nomPregunta;
	}

	public void setNomPregunta(String nomPregunta) {
		this.nomPregunta = nomPregunta;
	}

	

}
