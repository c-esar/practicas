package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_tipo_evaluacion_fisica")
public class TipoEvaluacionFisicaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_eval")
	private Long seqEval;

	@Column(name = "nom_eval")
	private String nomEval;

	public Long getSeqEval() {
		return seqEval;
	}

	public void setSeqEval(Long seqEval) {
		this.seqEval = seqEval;
	}

	public String getNomEval() {
		return nomEval;
	}

	public void setNomEval(String nomEval) {
		this.nomEval = nomEval;
	}

}
