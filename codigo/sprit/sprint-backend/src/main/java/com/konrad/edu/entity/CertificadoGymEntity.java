package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hc_certificado_gym")
public class CertificadoGymEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_certificado")
	private Long seqCertificado;

	@Column(name = "dat_fecha_certificado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datFechaCertificado;

	@Column(name = "nom_nombre")
	private String nombre;

	@Column(name = "num_numero")
	private String numero;

	@Column(name = "tipo_restriccion_limitacion")
	private String tipoRestriccionLimitacion;

	@Column(name = "recomendaciones")
	private String recomendaciones;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seq_eval")
	private TipoEvaluacionFisicaEntity tipoEvaluacionFisicaEntity;

	@OneToOne
	@JoinColumn(name = "seq_historia", nullable = false)
	private HistoriaGYMEntity seqHistoria;

	@PrePersist
	public void prePersist() {
		this.datFechaCertificado = new Date();
	}

	public Long getSeqCertificado() {
		return seqCertificado;
	}

	public void setSeqCertificado(Long seqCertificado) {
		this.seqCertificado = seqCertificado;
	}

	public Date getDatFechaCertificado() {
		return datFechaCertificado;
	}

	public void setDatFechaCertificado(Date datFechaCertificado) {
		this.datFechaCertificado = datFechaCertificado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoRestriccionLimitacion() {
		return tipoRestriccionLimitacion;
	}

	public void setTipoRestriccionLimitacion(String tipoRestriccionLimitacion) {
		this.tipoRestriccionLimitacion = tipoRestriccionLimitacion;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public HistoriaGYMEntity getSeqHistoria() {
		return seqHistoria;
	}

	public void setSeqHistoria(HistoriaGYMEntity seqHistoria) {
		this.seqHistoria = seqHistoria;
	}

	public TipoEvaluacionFisicaEntity getTipoEvaluacionFisicaEntity() {
		return tipoEvaluacionFisicaEntity;
	}

	public void setTipoEvaluacionFisicaEntity(TipoEvaluacionFisicaEntity tipoEvaluacionFisicaEntity) {
		this.tipoEvaluacionFisicaEntity = tipoEvaluacionFisicaEntity;
	}

}
