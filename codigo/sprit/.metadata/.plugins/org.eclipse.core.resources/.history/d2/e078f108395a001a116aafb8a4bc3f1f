package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hc_aseguradora")
public class AseguradoraEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_aseguradora", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqAseguradora;

	@Column(name = "tipo_aseguradora", nullable = false, unique = true)
	private String tipoAseguradora;

	@Column(name = "nom_aseguradora", nullable = false)
	private String nomAseguradora;

	public Long getSeqAseguradora() {
		return seqAseguradora;
	}

	public void setSeqAseguradora(Long seqAseguradora) {
		this.seqAseguradora = seqAseguradora;
	}

	public String getTipoAseguradora() {
		return tipoAseguradora;
	}

	public void setTipoAseguradora(String tipoAseguradora) {
		this.tipoAseguradora = tipoAseguradora;
	}

	public String getNomAseguradora() {
		return nomAseguradora;
	}

	public void setNomAseguradora(String nomAseguradora) {
		this.nomAseguradora = nomAseguradora;
	}

}
