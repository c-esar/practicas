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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hc_certificado")
public class CertificadoEntity implements Serializable{

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

	@Column(name = "exa_realizados")
	private String exaRealizados;

	@Column(name = "medico_certificado")
	private String medicoCertifica;

	@Column(name = "tipo_restriccion_limitacion")
	private String tipoRestriccionLimitacion;

	@Column(name = "recomendaciones")
	private String Recomendaciones;

	@Column(name = "control_epidemiologica")
	private String controlEpidemiologica;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_certificado_ocupacional", joinColumns = @JoinColumn(name = "seq_certificado", unique = false), 
			inverseJoinColumns = @JoinColumn(name = "seq_historia", unique = false), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia", "seq_certificado"}) })
	private HistoriaOcupacionalEntity historiaOcupacionalEntity;

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

	public String getExaRealizados() {
		return exaRealizados;
	}

	public void setExaRealizados(String exaRealizados) {
		this.exaRealizados = exaRealizados;
	}

	public String getMedicoCertifica() {
		return medicoCertifica;
	}

	public void setMedicoCertifica(String medicoCertifica) {
		this.medicoCertifica = medicoCertifica;
	}

	public String getTipoRestriccionLimitacion() {
		return tipoRestriccionLimitacion;
	}

	public void setTipoRestriccionLimitacion(String tipoRestriccionLimitacion) {
		this.tipoRestriccionLimitacion = tipoRestriccionLimitacion;
	}

	public String getRecomendaciones() {
		return Recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		Recomendaciones = recomendaciones;
	}

}
