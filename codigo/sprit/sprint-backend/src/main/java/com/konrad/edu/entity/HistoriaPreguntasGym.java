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
@Table(name = "hc_historias_preguntas_gym")
public class HistoriaPreguntasGym implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_historia_preguntas_gym")
	private Long seqHistoriasPreguntasGym;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_pregunta", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoPreguntaHistoriaGymEntity tipoPreguntaHistoriaGymEntity;

	@ManyToOne
	@JoinColumn(name = "seq_historia_gym")
	private HistoriaGYMEntity historiaGYMEntity;

	@Column(name = "estado_pregunta", length = 3)
	private String estadoPregunta;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "tiempo_fumando")
	private String tiempoFumando;

	@Column(name = "desp_cuales", length = 4000)
	private String despCuales;

	public Long getSeqHistoriasPreguntasGym() {
		return seqHistoriasPreguntasGym;
	}

	public void setSeqHistoriasPreguntasGym(Long seqHistoriasPreguntasGym) {
		this.seqHistoriasPreguntasGym = seqHistoriasPreguntasGym;
	}

	public TipoPreguntaHistoriaGymEntity getTipoPreguntaHistoriaGymEntity() {
		return tipoPreguntaHistoriaGymEntity;
	}

	public void setTipoPreguntaHistoriaGymEntity(TipoPreguntaHistoriaGymEntity tipoPreguntaHistoriaGymEntity) {
		this.tipoPreguntaHistoriaGymEntity = tipoPreguntaHistoriaGymEntity;
	}

	public String getEstadoPregunta() {
		return estadoPregunta;
	}

	public void setEstadoPregunta(String estadoPregunta) {
		this.estadoPregunta = estadoPregunta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTiempoFumando() {
		return tiempoFumando;
	}

	public void setTiempoFumando(String tiempoFumando) {
		this.tiempoFumando = tiempoFumando;
	}

	public String getDespCuales() {
		return despCuales;
	}

	public void setDespCuales(String despCuales) {
		this.despCuales = despCuales;
	}

	public HistoriaGYMEntity getHistoriaGYMEntity() {
		return historiaGYMEntity;
	}

	public void setHistoriaGYMEntity(HistoriaGYMEntity historiaGYMEntity) {
		this.historiaGYMEntity = historiaGYMEntity;
	}

}
