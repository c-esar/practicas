package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hc_paraclinicos")
public class ParaclinicosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seq_paraclinicos")
	private Long seqParaclinicos;
	
	@Column(name="desp_examen")
	private String despExamen;
	
	@Column(name="dat_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name="desp_resultado")
	private String despResultado;

	public Long getSeqParaclinicos() {
		return seqParaclinicos;
	}

	public void setSeqParaclinicos(Long seqParaclinicos) {
		this.seqParaclinicos = seqParaclinicos;
	}

	public String getDespExamen() {
		return despExamen;
	}

	public void setDespExamen(String despExamen) {
		this.despExamen = despExamen;
	}

	public String getDespResultado() {
		return despResultado;
	}

	public void setDespResultado(String despResultado) {
		this.despResultado = despResultado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
