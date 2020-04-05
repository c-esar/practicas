package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hc_tipo_usuario")
public class TipoUsuarioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seq_tipo_usuario")
	private Long seqTipoUsuario;
	
	@Column(name="nom_tipo_usuario")
	private String nomTipoUsuario;

	public Long getSeqTipoUsuario() {
		return seqTipoUsuario;
	}

	public void setSeqTipoUsuario(Long seqTipoUsuario) {
		this.seqTipoUsuario = seqTipoUsuario;
	}

	public String getNomTipoUsuario() {
		return nomTipoUsuario;
	}

	public void setNomTipoUsuario(String nomTipoUsuario) {
		this.nomTipoUsuario = nomTipoUsuario;
	}
	
}
