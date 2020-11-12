package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name = "hc_paraclinicos")
public class ParaclinicosEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_paraclinicos")
	private Long seqParaclinicos;

	@Column(name = "desp_examen")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_examen)")
	private byte[] despExamen;

	@Column(name = "dat_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name = "desp_resultado")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_resultado)")
	private byte[] despResultado;

	public Long getSeqParaclinicos() {
		return seqParaclinicos;
	}

	public void setSeqParaclinicos(Long seqParaclinicos) {
		this.seqParaclinicos = seqParaclinicos;
	}

	public byte[] getDespExamen() {
		return despExamen;
	}

	public void setDespExamen(byte[] despExamen) {
		this.despExamen = despExamen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public byte[] getDespResultado() {
		return despResultado;
	}

	public void setDespResultado(byte[] despResultado) {
		this.despResultado = despResultado;
	}

	

}
