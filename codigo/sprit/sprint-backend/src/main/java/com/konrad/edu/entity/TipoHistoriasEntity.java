package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_tipo_historia")
public class TipoHistoriasEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_tipo_historia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqTipoHistoria;

	@Column(name = "nom_tipo_historia")
	private String nomTipoHistoria;

	public Long getSeqTipoHistoria() {
		return seqTipoHistoria;
	}

	public void setSeqTipoHistoria(Long seqTipoHistoria) {
		this.seqTipoHistoria = seqTipoHistoria;
	}


	public String getNomTipoHistoria() {
		return nomTipoHistoria;
	}

	public void setNomTipoHistoria(String nomTipoHistoria) {
		this.nomTipoHistoria = nomTipoHistoria;
	}

}
