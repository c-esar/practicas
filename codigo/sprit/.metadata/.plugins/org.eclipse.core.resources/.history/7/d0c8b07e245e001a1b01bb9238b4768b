package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_examen_fisico")
public class ExamenFisico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_exa_fisico")
	private Long seqExaFisico;

	public Long getSeqExaFisico() {
		return seqExaFisico;
	}

	public void setSeqExaFisico(Long seqExaFisico) {
		this.seqExaFisico = seqExaFisico;
	}

}
