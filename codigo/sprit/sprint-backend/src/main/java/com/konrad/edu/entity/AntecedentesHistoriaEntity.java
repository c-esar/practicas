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
@Table(name = "hc_antecedentes_historia")
public class AntecedentesHistoriaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_ant_historias")
	private Long seqAntHistorias;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_antecedente", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoAntecedenteEntity tipoAntecedenteEntity;

	@Column(name = "estado_antecedente", length = 3)
	private String estadoAntecedente;

	@Column(name = "desp_antecedente", length = 4000)
	private String despAntecedente;

	@Column(length = 50)
	private String frecuencia;

	@Column(length = 50)
	private String tipo;

	@Column(length = 50)
	private String exFumador;

	@Column(name = "anos_habito")
	private int anosHabito;

	public Long getSeqAntHistorias() {
		return seqAntHistorias;
	}

	public void setSeqAntHistorias(Long seqAntHistorias) {
		this.seqAntHistorias = seqAntHistorias;
	}

	public String getEstadoAntecedente() {
		return estadoAntecedente;
	}

	public void setEstadoAntecedente(String estadoAntecedente) {
		this.estadoAntecedente = estadoAntecedente;
	}

	public String getDespAntecedente() {
		return despAntecedente;
	}

	public void setDespAntecedente(String despAntecedente) {
		this.despAntecedente = despAntecedente;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExFumador() {
		return exFumador;
	}

	public void setExFumador(String exFumador) {
		this.exFumador = exFumador;
	}

	public int getAnosHabito() {
		return anosHabito;
	}

	public void setAnosHabito(int anosHabito) {
		this.anosHabito = anosHabito;
	}

	public TipoAntecedenteEntity getTipoAntecedenteEntity() {
		return tipoAntecedenteEntity;
	}

	public void setTipoAntecedenteEntity(TipoAntecedenteEntity tipoAntecedenteEntity) {
		this.tipoAntecedenteEntity = tipoAntecedenteEntity;
	}

}
