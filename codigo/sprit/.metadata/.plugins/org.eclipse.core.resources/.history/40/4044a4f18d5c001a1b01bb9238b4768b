package com.konrad.edu.entity;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "hc_antecedentes_trabajo")
public class AntecedentesTrabajoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_ant")
	private Long seqAnt;

	@Column(name = "dat_fecha_ant")
	private Date fechaAnt;

	@Column(name = "nom_empresa", length = 50)
	private String nomEmpresa;

	@Column(name = "desp_causa", length = 4000)
	@Lob
	private Clob despCausa;

	@Column(name = "tipo_lesion", length = 50)
	private String tipoLesion;

	@Column(name = "parte_afectada", length = 50)
	private String parteAfectada;

	@Column(name = "desp_incapacidad", length = 4000)
	@Lob
	private Clob despIncapacidad;

	@Column(name = "desp_secuelas", length = 4000)
	@Lob
	private Clob despSecuelas;

	public Long getSeqAnt() {
		return seqAnt;
	}

	public void setSeqAnt(Long seqAnt) {
		this.seqAnt = seqAnt;
	}

	public Date getFechaAnt() {
		return fechaAnt;
	}

	public void setFechaAnt(Date fechaAnt) {
		this.fechaAnt = fechaAnt;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}



	public String getTipoLesion() {
		return tipoLesion;
	}

	public void setTipoLesion(String tipoLesion) {
		this.tipoLesion = tipoLesion;
	}

	public String getParteAfectada() {
		return parteAfectada;
	}

	public void setParteAfectada(String parteAfectada) {
		this.parteAfectada = parteAfectada;
	}

	public Clob getDespCausa() {
		return despCausa;
	}

	public void setDespCausa(Clob despCausa) {
		this.despCausa = despCausa;
	}

	public Clob getDespIncapacidad() {
		return despIncapacidad;
	}

	public void setDespIncapacidad(Clob despIncapacidad) {
		this.despIncapacidad = despIncapacidad;
	}

	public Clob getDespSecuelas() {
		return despSecuelas;
	}

	public void setDespSecuelas(Clob despSecuelas) {
		this.despSecuelas = despSecuelas;
	}

	

}
