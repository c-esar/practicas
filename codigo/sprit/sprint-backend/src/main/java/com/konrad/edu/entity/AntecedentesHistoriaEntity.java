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

import org.hibernate.annotations.ColumnTransformer;

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

	@Column(name = "estado_antecedente")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',estado_antecedente)")
	private byte[] estadoAntecedente;

	@Column(name = "desp_antecedente")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_antecedente)")
	private byte[] despAntecedente;

	@Column(name = "frecuencia")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',frecuencia)")
	private byte[] frecuencia;

	@Column(name = "tipo")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',tipo)")
	private byte[] tipo;

	@Column(name = "ex_fumador")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',ex_fumador)")
	private byte[] exFumador;

	@Column(name = "anos_habito")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',anos_habito)")
	private byte[] anosHabito;

	@Column(name = "planificacion")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',planificacion)")
	private byte[] planificacion;

	// fecha ultima citoligias y resultados
	@Column(name = "ccv")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',ccv)")
	private byte[] ccv;

	// fecha ultima mestruacion
	@Temporal(TemporalType.TIMESTAMP)
	private Date fur;

	@Column(name = "menarquia")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia)")
	private byte[] mernarquia;

	@Column(name = "menarquia_gestaciones")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia_gestaciones)")
	private byte[] menarquiaGestaciones;

	@Column(name = "menarquia_partos")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia_partos)")
	private byte[] menarquiaPartos;

	@Column(name = "menarquia_cesarias")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia_cesarias)")
	private byte[] menarquiaCesarias;

	@Column(name = "menarquia_abortos")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia_abortos)")
	private byte[] menarquiaAbortos;

	@Column(name = "menarquia_vivos")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',menarquia_vivos)")
	private byte[] menarquiaVivos;

	public Long getSeqAntHistorias() {
		return seqAntHistorias;
	}

	public void setSeqAntHistorias(Long seqAntHistorias) {
		this.seqAntHistorias = seqAntHistorias;
	}

	public TipoAntecedenteEntity getTipoAntecedenteEntity() {
		return tipoAntecedenteEntity;
	}

	public void setTipoAntecedenteEntity(TipoAntecedenteEntity tipoAntecedenteEntity) {
		this.tipoAntecedenteEntity = tipoAntecedenteEntity;
	}

	public byte[] getEstadoAntecedente() {
		return estadoAntecedente;
	}

	public void setEstadoAntecedente(byte[] estadoAntecedente) {
		this.estadoAntecedente = estadoAntecedente;
	}

	public byte[] getDespAntecedente() {
		return despAntecedente;
	}

	public void setDespAntecedente(byte[] despAntecedente) {
		this.despAntecedente = despAntecedente;
	}

	public byte[] getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(byte[] frecuencia) {
		this.frecuencia = frecuencia;
	}

	public byte[] getTipo() {
		return tipo;
	}

	public void setTipo(byte[] tipo) {
		this.tipo = tipo;
	}

	public byte[] getExFumador() {
		return exFumador;
	}

	public void setExFumador(byte[] exFumador) {
		this.exFumador = exFumador;
	}

	public byte[] getAnosHabito() {
		return anosHabito;
	}

	public void setAnosHabito(byte[] anosHabito) {
		this.anosHabito = anosHabito;
	}

	public byte[] getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(byte[] planificacion) {
		this.planificacion = planificacion;
	}

	public byte[] getCcv() {
		return ccv;
	}

	public void setCcv(byte[] ccv) {
		this.ccv = ccv;
	}

	public Date getFur() {
		return fur;
	}

	public void setFur(Date fur) {
		this.fur = fur;
	}

	public byte[] getMernarquia() {
		return mernarquia;
	}

	public void setMernarquia(byte[] mernarquia) {
		this.mernarquia = mernarquia;
	}

	public byte[] getMenarquiaGestaciones() {
		return menarquiaGestaciones;
	}

	public void setMenarquiaGestaciones(byte[] menarquiaGestaciones) {
		this.menarquiaGestaciones = menarquiaGestaciones;
	}

	public byte[] getMenarquiaPartos() {
		return menarquiaPartos;
	}

	public void setMenarquiaPartos(byte[] menarquiaPartos) {
		this.menarquiaPartos = menarquiaPartos;
	}

	public byte[] getMenarquiaCesarias() {
		return menarquiaCesarias;
	}

	public void setMenarquiaCesarias(byte[] menarquiaCesarias) {
		this.menarquiaCesarias = menarquiaCesarias;
	}

	public byte[] getMenarquiaAbortos() {
		return menarquiaAbortos;
	}

	public void setMenarquiaAbortos(byte[] menarquiaAbortos) {
		this.menarquiaAbortos = menarquiaAbortos;
	}

	public byte[] getMenarquiaVivos() {
		return menarquiaVivos;
	}

	public void setMenarquiaVivos(byte[] menarquiaVivos) {
		this.menarquiaVivos = menarquiaVivos;
	}

}
