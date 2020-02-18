package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="hc_Personas")
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seqPersona;
	
	@Column(name="nom_primer_nombre")
	private String nomPrimerNombre;

	public Integer getSeqPersona() {
		return seqPersona;
	}

	public void setSeqPersona(Integer seqPersona) {
		this.seqPersona = seqPersona;
	}

	public String getNomPrimerNombre() {
		return nomPrimerNombre;
	}

	public void setNomPrimerNombre(String nomPrimerNombre) {
		this.nomPrimerNombre = nomPrimerNombre;
	}

}
