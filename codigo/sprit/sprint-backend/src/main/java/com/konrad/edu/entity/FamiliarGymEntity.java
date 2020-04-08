package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hc_familiar_gym")
public class FamiliarGymEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seq_familiar_gym")
	private Long seqFamiliarGym;
	
	@Column(name="nom_familiar")
	private String nomFamiliar;

	public Long getSeqFamiliarGym() {
		return seqFamiliarGym;
	}

	public void setSeqFamiliarGym(Long seqFamiliarGym) {
		this.seqFamiliarGym = seqFamiliarGym;
	}

	public String getNomFamiliar() {
		return nomFamiliar;
	}

	public void setNomFamiliar(String nomFamiliar) {
		this.nomFamiliar = nomFamiliar;
	}
	
		
}
