package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_condicion_gym")
public class CondicionGymEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_condicion_gym")
	private Long seqCondicionGym;

	@Column(name = "nom_condicion")
	private String nomCondicion;

	public Long getSeqCondicionGym() {
		return seqCondicionGym;
	}

	public void setSeqCondicionGym(Long seqCondicionGym) {
		this.seqCondicionGym = seqCondicionGym;
	}

	public String getNomCondicion() {
		return nomCondicion;
	}

	public void setNomCondicion(String nomCondicion) {
		this.nomCondicion = nomCondicion;
	}

}
