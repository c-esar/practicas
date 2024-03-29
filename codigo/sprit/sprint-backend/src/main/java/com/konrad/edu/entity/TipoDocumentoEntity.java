package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_tipo_documento")
public class TipoDocumentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_tipo_documento")
	private Long seqTipoDocumento;

	@Column(name = "cod_documento", nullable = false)
	private String codDocumento;

	@Column(name = "sigla_documento", nullable = false, unique = true)
	private String siglaDocumento;

	@Column(name = "nom_documento", nullable = false)
	private String nomDocumento;

	public Long getSeqTipoDocumento() {
		return seqTipoDocumento;
	}

	public void setSeqTipoDocumento(Long seqTipoDocumento) {
		this.seqTipoDocumento = seqTipoDocumento;
	}

	public String getCodDocumento() {
		return codDocumento;
	}

	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}

	public String getSiglaDocumento() {
		return siglaDocumento;
	}

	public void setSiglaDocumento(String siglaDocumento) {
		this.siglaDocumento = siglaDocumento;
	}

	public String getNomDocumento() {
		return nomDocumento;
	}

	public void setNomDocumento(String nomDocumento) {
		this.nomDocumento = nomDocumento;
	}

}
