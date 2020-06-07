package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_cuestionario_gym")
public class CuestionarioGymEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_cuestionario_gym")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqCuestionarioGym;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_cuestionario", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoCuestionarioEntity tipoCuestionarioEntity;

	@ManyToOne
	@JoinColumn(name = "seq_historia_gym")
	private HistoriaGYMEntity historiaGYMEntity;

	@Column(name = "estado_cuestionario")
	private String estadoCuestionario;

	public Long getSeqCuestionarioGym() {
		return seqCuestionarioGym;
	}

	public void setSeqCuestionarioGym(Long seqCuestionarioGym) {
		this.seqCuestionarioGym = seqCuestionarioGym;
	}

	public TipoCuestionarioEntity getTipoCuestionarioEntity() {
		return tipoCuestionarioEntity;
	}

	public void setTipoCuestionarioEntity(TipoCuestionarioEntity tipoCuestionarioEntity) {
		this.tipoCuestionarioEntity = tipoCuestionarioEntity;
	}

	public String getEstadoCuestionario() {
		return estadoCuestionario;
	}

	public void setEstadoCuestionario(String estadoCuestionario) {
		this.estadoCuestionario = estadoCuestionario;
	}

	public HistoriaGYMEntity getHistoriaGYMEntity() {
		return historiaGYMEntity;
	}

	public void setHistoriaGYMEntity(HistoriaGYMEntity historiaGYMEntity) {
		this.historiaGYMEntity = historiaGYMEntity;
	}

}
