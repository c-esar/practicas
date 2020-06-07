package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriaOcupacionalEncriptacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long seqHistoria;
	private TipoHistoriasEntity seqTipoHistoria;
	private ExamenFisicoEncriptacion examenFisico;
	private HistoriaLaboralEntity historiaLaboral;
	private List<AntecedentesHistoriaEntity> antecedentesHistoriaEntity;
	private List<ParaclinicosEntity> paraclinicosEntity;
	private TipoEvaluacionEntity tipoEvaluacionEntity;
	private CiudadEntity ciudadHistoria;
	private List<ConceptoEntity> conceptoConcepto;
	private List<DiagnosticoEntity> diagnosticoOcupacionalEntity;
	private Date diaHistoria;
	private String despMotivoConsulta;
	private String revisionSistemas;
	private String recomMedicas;
	private String recomOcupacionales;
	private String recomHabitos;
	private String otroEvaluacion;
	private String aceptoCondiciones;
	private PersonaEntity persona;
	private Long personaMedico;

	public HistoriaOcupacionalEncriptacion() {
		this.antecedentesHistoriaEntity = new ArrayList<>();
		this.paraclinicosEntity = new ArrayList<>();
		this.conceptoConcepto = new ArrayList<>();
		this.diagnosticoOcupacionalEntity = new ArrayList<>();
		this.diaHistoria = new Date();
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

	public ExamenFisicoEncriptacion getExamenFisico() {
		return examenFisico;
	}

	public void setExamenFisico(ExamenFisicoEncriptacion examenFisico) {
		this.examenFisico = examenFisico;
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

	public List<ParaclinicosEntity> getParaclinicosEntity() {
		return paraclinicosEntity;
	}

	public void setParaclinicosEntity(List<ParaclinicosEntity> paraclinicosEntity) {
		this.paraclinicosEntity = paraclinicosEntity;
	}

	public TipoEvaluacionEntity getTipoEvaluacionEntity() {
		return tipoEvaluacionEntity;
	}

	public void setTipoEvaluacionEntity(TipoEvaluacionEntity tipoEvaluacionEntity) {
		this.tipoEvaluacionEntity = tipoEvaluacionEntity;
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

	public String getOtroEvaluacion() {
		return otroEvaluacion;
	}

	public void setOtroEvaluacion(String otroEvaluacion) {
		this.otroEvaluacion = otroEvaluacion;
	}

	public String getAceptoCondiciones() {
		return aceptoCondiciones;
	}

	public void setAceptoCondiciones(String aceptoCondiciones) {
		this.aceptoCondiciones = aceptoCondiciones;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public Long getPersonaMedico() {
		return personaMedico;
	}

	public void setPersonaMedico(Long personaMedico) {
		this.personaMedico = personaMedico;
	}

}
