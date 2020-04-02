package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_historias")
public class HistoriasEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "seq_historia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqHistoria;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_historia")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoHistoriasEntity seqTipoHistoria;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_exa_fisico", unique = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenFisicoEntity examenFisico;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral", unique = true )
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private HistoriaLaboralEntity historiaLaboral;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia")
	private List<AntecedentesHistoriaEntity> antecedentesHistoriaEntity;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia")
	private List<ParaclinicosEntity> paraclinicosEntity;

	@ManyToOne
	@JoinColumn(name = "seq_eval")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoEvaluacionEntity tipoEvaluacionEntity;

	@ManyToOne
	@JoinColumn(name = "seq_ciudad", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity ciudadHistoria;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_concepto_historia", joinColumns = @JoinColumn(name = "seq_historia",referencedColumnName = "seq_historia"), inverseJoinColumns = @JoinColumn(name = "seq_concepto",referencedColumnName = "seq_concepto"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia", "seq_concepto" }) })
	private List<ConceptoEntity> conceptoConcepto;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_diagnosticoOcupacional_historia", joinColumns = @JoinColumn(name = "seq_historia"), inverseJoinColumns = @JoinColumn(name = "seq_diagnostico"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia", "seq_diagnostico" }) })
	private List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity;

	@Column(name = "dia_historia")
	@Temporal(TemporalType.DATE)
	private Date diaHistoria;

	@Column(name = "desp_motivo_consulta", length = 4000)
	private String despMotivoConsulta;

	@Column(name = "revision_sistemas", length = 4000)
	private String revisionSistemas;

	@Column(name = "recom_medicas", length = 4000)
	private String recomMedicas;

	@Column(name = "recom_ocupacionales", length = 4000)
	private String recomOcupacionales;

	@Column(name = "recom_habitos", length = 4000)
	private String recomHabitos;
	
	@Column(name="otro_evaluacion")
	private String otroEvaluacion;

	@PrePersist
	public void prePersist() {
		this.diaHistoria = new Date();
	}
	

	public HistoriasEntity() {
		this.antecedentesHistoriaEntity = new ArrayList<>();
		this.paraclinicosEntity = new ArrayList<>();
		this.conceptoConcepto = new ArrayList<>();
		this.diagnosticoOcupacionalEntity = new ArrayList<>();
	}

	public Long getSeqHistoria() {
		return seqHistoria;
	}

	public void setSeqHistoria(Long seqHistoria) {
		this.seqHistoria = seqHistoria;
	}

	public TipoHistoriasEntity getSeqTipoHistoria() {
		return seqTipoHistoria;
	}

	public void setSeqTipoHistoria(TipoHistoriasEntity seqTipoHistoria) {
		this.seqTipoHistoria = seqTipoHistoria;
	}

	public HistoriaLaboralEntity getHistoriaLaboral() {
		return historiaLaboral;
	}

	public void setHistoriaLaboral(HistoriaLaboralEntity historiaLaboral) {
		this.historiaLaboral = historiaLaboral;
	}

	public List<AntecedentesHistoriaEntity> getAntecedentesHistoriaEntity() {
		return antecedentesHistoriaEntity;
	}

	public void setAntecedentesHistoriaEntity(List<AntecedentesHistoriaEntity> antecedentesHistoriaEntity) {
		this.antecedentesHistoriaEntity = antecedentesHistoriaEntity;
	}

	public TipoEvaluacionEntity getTipoEvaluacionEntity() {
		return tipoEvaluacionEntity;
	}

	public void setTipoEvaluacionEntity(TipoEvaluacionEntity tipoEvaluacionEntity) {
		this.tipoEvaluacionEntity = tipoEvaluacionEntity;
	}

	public CiudadEntity getLugarNacimiento() {
		return ciudadHistoria;
	}

	public void setLugarNacimiento(CiudadEntity lugarNacimiento) {
		this.ciudadHistoria = lugarNacimiento;
	}

	public Date getDiaHistoria() {
		return diaHistoria;
	}

	public void setDiaHistoria(Date diaHistoria) {
		this.diaHistoria = diaHistoria;
	}

	public String getDespMotivoConsulta() {
		return despMotivoConsulta;
	}

	public void setDespMotivoConsulta(String despMotivoConsulta) {
		this.despMotivoConsulta = despMotivoConsulta;
	}

	public String getRevisionSistemas() {
		return revisionSistemas;
	}

	public void setRevisionSistemas(String revisionSistemas) {
		this.revisionSistemas = revisionSistemas;
	}

	public String getRecomMedicas() {
		return recomMedicas;
	}

	public void setRecomMedicas(String recomMedicas) {
		this.recomMedicas = recomMedicas;
	}

	public String getRecomOcupacionales() {
		return recomOcupacionales;
	}

	public void setRecomOcupacionales(String recomOcupacionales) {
		this.recomOcupacionales = recomOcupacionales;
	}

	public String getRecomHabitos() {
		return recomHabitos;
	}

	public void setRecomHabitos(String recomHabitos) {
		this.recomHabitos = recomHabitos;
	}

	public ExamenFisicoEntity getExamenFisico() {
		return examenFisico;
	}

	public void setExamenFisico(ExamenFisicoEntity examenFisico) {
		this.examenFisico = examenFisico;
	}

	public List<ParaclinicosEntity> getParaclinicosEntity() {
		return paraclinicosEntity;
	}

	public void setParaclinicosEntity(List<ParaclinicosEntity> paraclinicosEntity) {
		this.paraclinicosEntity = paraclinicosEntity;
	}

	public CiudadEntity getCiudadHistoria() {
		return ciudadHistoria;
	}

	public void setCiudadHistoria(CiudadEntity ciudadHistoria) {
		this.ciudadHistoria = ciudadHistoria;
	}

	public List<ConceptoEntity> getConceptoConcepto() {
		return conceptoConcepto;
	}

	public void setConceptoConcepto(List<ConceptoEntity> conceptoConcepto) {
		this.conceptoConcepto = conceptoConcepto;
	}

	public String getOtroEvaluacion() {
		return otroEvaluacion;
	}

	public void setOtroEvaluacion(String otroEvaluacion) {
		this.otroEvaluacion = otroEvaluacion;
	}


	public List<DiagnosticoOcupacionalEntity> getDiagnosticoOcupacionalEntity() {
		return diagnosticoOcupacionalEntity;
	}


	public void setDiagnosticoOcupacionalEntity(List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity) {
		this.diagnosticoOcupacionalEntity = diagnosticoOcupacionalEntity;
	}
	
}
