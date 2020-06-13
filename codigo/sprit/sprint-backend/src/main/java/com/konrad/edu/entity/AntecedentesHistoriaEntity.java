package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@OneToOne
	@JoinColumn(name = "seq_tipo_antecedente")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoAntecedenteEntity tipoAntecedenteEntity;

	@Column(name = "estado_antecedente", length = 3)
	private String estadoAntecedente;

	@Column(name = "desp_antecedente", length = 4000)
	private String despAntecedente;

	@Column(length = 100)
	private String frecuencia;

	@Column(length = 100)
	private String tipo;

	@Column(length = 100)
	private String exFumador;

	@Column(name = "anos_habito")
	private String anosHabito;

	@Column(name="planificacion", length = 100)
	private String planificacion;

	// fecha ultima citoligias y resultados
	private String ccv;

	// fecha ultima mestruacion
	@Temporal(TemporalType.TIMESTAMP)
	private Date fur;

	@Column(name = "menarquia")
	private String mernarquia;

	@Column(name = "menarquia_gestaciones")
	private String menarquiaGestaciones;
	
	@Column(name = "menarquia_partos")
	private String menarquiaPartos;
	
	@Column(name = "menarquia_cesarias")
	private String menarquiaCesarias;
	
	@Column(name = "menarquia_abortos")
	private String menarquiaAbortos;
	
	@Column(name = "menarquia_vivos")
	private String menarquiaVivos;

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

	public String getAnosHabito() {
		return anosHabito;
	}

	public void setAnosHabito(String anosHabito) {
		this.anosHabito = anosHabito;
	}

	public TipoAntecedenteEntity getTipoAntecedenteEntity() {
		return tipoAntecedenteEntity;
	}

	public void setTipoAntecedenteEntity(TipoAntecedenteEntity tipoAntecedenteEntity) {
		this.tipoAntecedenteEntity = tipoAntecedenteEntity;
	}

	public String getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(String planificacion) {
		this.planificacion = planificacion;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	

	public String getMenarquiaGestaciones() {
		return menarquiaGestaciones;
	}

	public void setMenarquiaGestaciones(String menarquiaGestaciones) {
		this.menarquiaGestaciones = menarquiaGestaciones;
	}

	public String getMenarquiaPartos() {
		return menarquiaPartos;
	}

	public void setMenarquiaPartos(String menarquiaPartos) {
		this.menarquiaPartos = menarquiaPartos;
	}

	public String getMenarquiaCesarias() {
		return menarquiaCesarias;
	}

	public void setMenarquiaCesarias(String menarquiaCesarias) {
		this.menarquiaCesarias = menarquiaCesarias;
	}

	public String getMenarquiaAbortos() {
		return menarquiaAbortos;
	}

	public void setMenarquiaAbortos(String menarquiaAbortos) {
		this.menarquiaAbortos = menarquiaAbortos;
	}

	public String getMenarquiaVivos() {
		return menarquiaVivos;
	}

	public void setMenarquiaVivos(String menarquiaVivos) {
		this.menarquiaVivos = menarquiaVivos;
	}

	public Date getFur() {
		return fur;
	}

	public void setFur(Date fur) {
		this.fur = fur;
	}

	public String getMernarquia() {
		return mernarquia;
	}

	public void setMernarquia(String mernarquia) {
		this.mernarquia = mernarquia;
	}

}
