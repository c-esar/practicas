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
@Table(name = "hc_historia_gym")
public class HistoriaGYMEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "seq_historia_gym")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqHistoriaGym;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_historia")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoHistoriasEntity seqTipoHistoria;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_exa_fisico", unique = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenFisicoEntity examenFisico;


	@ManyToOne
	@JoinColumn(name = "seq_ciudad", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity ciudadHistoria;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_gym")
	private List<HistoriaPreguntasGym> historiaPreguntasGyms;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_diagnosticoGym_historia", joinColumns = @JoinColumn(name = "seq_historia_gym"), inverseJoinColumns = @JoinColumn(name = "seq_diagnostico"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_gym", "seq_diagnostico" }) })
	private List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_condiciones_historiaGym", joinColumns = @JoinColumn(name = "seq_historia_gym"), inverseJoinColumns = @JoinColumn(name = "seq_condicion_gym"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_gym", "seq_condicion_gym" }) })
	private List<CondicionGymEntity> condicionGymEntity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_familiar_historiaGym", joinColumns = @JoinColumn(name = "seq_historia_gym"), inverseJoinColumns = @JoinColumn(name = "seq_familiar_gym"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_gym", "seq_familiar_gym" }) })
	private List<FamiliarGymEntity> familiarGymEntity;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_gym")
	private List<CuestionarioGymEntity> cuestionarioGymEntity;

	@Column(name = "dia_historia_gym")
	@Temporal(TemporalType.DATE)
	private Date diaHistoriaGym;

	@Column(name = "observaciones_historia", length = 4000)
	private String observacionesHistoria;

	@Column(name = "otra_condicion", length = 4000)
	private String otraCondicion;
	
	@Column(name="otra_familiar", length = 4000)
	private String otraFamiliar;
	
	@Column(name="tipo_cancer", length = 4000)
	private String tipoCancer;

	@Column(name = "conducta", length = 4000)
	private String conducta;


	@PrePersist
	public void prePersist() {
		this.diaHistoriaGym = new Date();
	}
	

	public HistoriaGYMEntity() {
		this.historiaPreguntasGyms = new ArrayList<>();
		this.diagnosticoOcupacionalEntity = new ArrayList<>();
		this.condicionGymEntity = new ArrayList<>();
		this.familiarGymEntity = new ArrayList<>();
	}


	public Long getSeqHistoriaGym() {
		return seqHistoriaGym;
	}


	public void setSeqHistoriaGym(Long seqHistoriaGym) {
		this.seqHistoriaGym = seqHistoriaGym;
	}


	public TipoHistoriasEntity getSeqTipoHistoria() {
		return seqTipoHistoria;
	}


	public void setSeqTipoHistoria(TipoHistoriasEntity seqTipoHistoria) {
		this.seqTipoHistoria = seqTipoHistoria;
	}


	public ExamenFisicoEntity getExamenFisico() {
		return examenFisico;
	}


	public void setExamenFisico(ExamenFisicoEntity examenFisico) {
		this.examenFisico = examenFisico;
	}


	public CiudadEntity getCiudadHistoria() {
		return ciudadHistoria;
	}


	public void setCiudadHistoria(CiudadEntity ciudadHistoria) {
		this.ciudadHistoria = ciudadHistoria;
	}


	public List<HistoriaPreguntasGym> getHistoriaPreguntasGyms() {
		return historiaPreguntasGyms;
	}


	public void setHistoriaPreguntasGyms(List<HistoriaPreguntasGym> historiaPreguntasGyms) {
		this.historiaPreguntasGyms = historiaPreguntasGyms;
	}


	public List<DiagnosticoOcupacionalEntity> getDiagnosticoOcupacionalEntity() {
		return diagnosticoOcupacionalEntity;
	}


	public void setDiagnosticoOcupacionalEntity(List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity) {
		this.diagnosticoOcupacionalEntity = diagnosticoOcupacionalEntity;
	}


	public Date getDiaHistoriaGym() {
		return diaHistoriaGym;
	}


	public void setDiaHistoriaGym(Date diaHistoriaGym) {
		this.diaHistoriaGym = diaHistoriaGym;
	}


	public String getObservacionesHistoria() {
		return observacionesHistoria;
	}


	public void setObservacionesHistoria(String observacionesHistoria) {
		this.observacionesHistoria = observacionesHistoria;
	}


	public String getOtraCondicion() {
		return otraCondicion;
	}


	public void setOtraCondicion(String otraCondicion) {
		this.otraCondicion = otraCondicion;
	}


	public String getConducta() {
		return conducta;
	}


	public void setConducta(String conducta) {
		this.conducta = conducta;
	}


	public List<CuestionarioGymEntity> getCuestionarioGymEntity() {
		return cuestionarioGymEntity;
	}


	public void setCuestionarioGymEntity(List<CuestionarioGymEntity> cuestionarioGymEntity) {
		this.cuestionarioGymEntity = cuestionarioGymEntity;
	}


	public List<CondicionGymEntity> getCondicionGymEntity() {
		return condicionGymEntity;
	}


	public void setCondicionGymEntity(List<CondicionGymEntity> condicionGymEntity) {
		this.condicionGymEntity = condicionGymEntity;
	}


	public String getOtraFamiliar() {
		return otraFamiliar;
	}


	public void setOtraFamiliar(String otraFamiliar) {
		this.otraFamiliar = otraFamiliar;
	}


	public List<FamiliarGymEntity> getFamiliarGymEntity() {
		return familiarGymEntity;
	}


	public void setFamiliarGymEntity(List<FamiliarGymEntity> familiarGymEntity) {
		this.familiarGymEntity = familiarGymEntity;
	}

	
	
	
}
