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
import javax.persistence.Index;
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

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_historia_ocupacional")
public class HistoriaOcupacionalEntity implements Serializable {

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_exa_fisico", unique = true)
	private ExamenFisicoEntity examenFisico;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral", unique = true)
	private HistoriaLaboralEntity historiaLaboral;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<AntecedentesHistoriaEntity> antecedentesHistoriaEntity;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<ParaclinicosEntity> paraclinicosEntity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seq_eval")
	private TipoEvaluacionEntity tipoEvaluacionEntity;

	@ManyToOne
	@JoinColumn(name = "seq_ciudad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity ciudadHistoria;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_concepto_historia", joinColumns = @JoinColumn(name = "seq_historia", referencedColumnName = "seq_historia"), inverseJoinColumns = @JoinColumn(name = "seq_concepto", referencedColumnName = "seq_concepto"), indexes = {
			@Index(name = "seq_historia", columnList = "seq_historia", unique = false),
			@Index(name = "seq_concepto", columnList = "seq_concepto", unique = true) })
	private List<ConceptoEntity> conceptoConcepto;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_diagnosticoOcupacional_historia", joinColumns = @JoinColumn(name = "seq_historia"), inverseJoinColumns = @JoinColumn(name = "seq_diagnostico"), indexes = {
			@Index(name = "seq_historia", columnList = "seq_historia", unique = false),
			@Index(name = "seq_diagnostico", columnList = "seq_diagnostico", unique = true) })
	private List<DiagnosticoEntity> diagnosticoOcupacionalEntity;

	@Column(name = "dia_historia")
	@Temporal(TemporalType.DATE)
	private Date diaHistoria;

	@Column(name = "desp_motivo_consulta")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_motivo_consulta)")
	private byte[] despMotivoConsulta;

	@Column(name = "revision_sistemas")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',revision_sistemas)")
	private byte[] revisionSistemas;

	@Column(name = "recom_medicas")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',recom_medicas)")
	private byte[] recomMedicas;

	@Column(name = "recom_ocupacionales")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',recom_ocupacionales)")
	private byte[] recomOcupacionales;

	@Column(name = "recom_habitos")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',recom_habitos)")
	private byte[] recomHabitos;

	@Column(name = "otro_evaluacion")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',otro_evaluacion)")
	private byte[] otroEvaluacion;

	@Column(name = "acepto_condiciones")
	private String aceptoCondiciones;

	@ManyToOne
	@JoinColumn(name = "seq_persona")
	private PersonaEntity persona;

	@Column(name = "persona_medico")
	private Long personaMedico;

	@PrePersist
	public void prePersist() {
		this.diaHistoria = new Date();
	}

	public HistoriaOcupacionalEntity() {
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

	public List<DiagnosticoEntity> getDiagnosticoOcupacionalEntity() {
		return diagnosticoOcupacionalEntity;
	}

	public void setDiagnosticoOcupacionalEntity(List<DiagnosticoEntity> diagnosticoOcupacionalEntity) {
		this.diagnosticoOcupacionalEntity = diagnosticoOcupacionalEntity;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public byte[] getDespMotivoConsulta() {
		return despMotivoConsulta;
	}

	public void setDespMotivoConsulta(byte[] despMotivoConsulta) {
		this.despMotivoConsulta = despMotivoConsulta;
	}

	public byte[] getRevisionSistemas() {
		return revisionSistemas;
	}

	public void setRevisionSistemas(byte[] revisionSistemas) {
		this.revisionSistemas = revisionSistemas;
	}

	public byte[] getRecomMedicas() {
		return recomMedicas;
	}

	public void setRecomMedicas(byte[] recomMedicas) {
		this.recomMedicas = recomMedicas;
	}

	public byte[] getRecomOcupacionales() {
		return recomOcupacionales;
	}

	public void setRecomOcupacionales(byte[] recomOcupacionales) {
		this.recomOcupacionales = recomOcupacionales;
	}

	public byte[] getRecomHabitos() {
		return recomHabitos;
	}

	public void setRecomHabitos(byte[] recomHabitos) {
		this.recomHabitos = recomHabitos;
	}

	public byte[] getOtroEvaluacion() {
		return otroEvaluacion;
	}

	public void setOtroEvaluacion(byte[] otroEvaluacion) {
		this.otroEvaluacion = otroEvaluacion;
	}

	public String getAceptoCondiciones() {
		return aceptoCondiciones;
	}

	public void setAceptoCondiciones(String aceptoCondiciones) {
		this.aceptoCondiciones = aceptoCondiciones;
	}

	public Long getPersonaMedico() {
		return personaMedico;
	}

	public void setPersonaMedico(Long personaMedico) {
		this.personaMedico = personaMedico;
	}

}
