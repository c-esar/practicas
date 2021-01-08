package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

public class AntecedentesHistoriaEntityEncriptacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long seqAntHistorias;
	private TipoAntecedenteEntity tipoAntecedenteEntity;
	private String estadoAntecedente;
	private String despAntecedente;
	private String frecuencia;
	private String tipo;
	private String exFumador;
	private String anosHabito;
	private String planificacion;
	// fecha ultima citoligias y resultados
	private String ccv;
	// fecha ultima mestruacion
	private Date fur;
	private String mernarquia;
	private String menarquiaGestaciones;
	private String menarquiaPartos;
	private String menarquiaCesarias;
	private String menarquiaAbortos;
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
