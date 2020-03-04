package com.konrad.edu.entity;

import java.io.Serializable;
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

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_tipo_historia", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoHistorias seqTipoHistoria;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_exa_fisico", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenFisicoEntity examenFisico;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_historia_laboral", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private HistoriaLaboralEntity historiaLaboral;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_historia_antecedentehistoria", joinColumns = @JoinColumn(name = "seq_historia"), inverseJoinColumns = @JoinColumn(name = "seq_ant_historias"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia", "seq_ant_historias" }) })
	private List<AntecedentesHistoriaEntity> antecedentesHistoriaEntity;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_eval", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoEvaluacionEntity tipoEvaluacionEntity;

	@OneToOne
	@JoinColumn(name = "seq_ciudad", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity ciudadHistoria;

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

	@PrePersist
	public void prePersist() {
		this.diaHistoria = new Date();
	}

	// falta concepto

	// falta exam_fisico
	public Long getSeqHistoria() {
		return seqHistoria;
	}

	public void setSeqHistoria(Long seqHistoria) {
		this.seqHistoria = seqHistoria;
	}

	public TipoHistorias getSeqTipoHistoria() {
		return seqTipoHistoria;
	}

	public void setSeqTipoHistoria(TipoHistorias seqTipoHistoria) {
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

}
