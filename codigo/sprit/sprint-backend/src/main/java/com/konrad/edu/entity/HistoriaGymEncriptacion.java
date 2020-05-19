package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriaGymEncriptacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long seqHistoriaGym;

	private TipoHistoriasEntity seqTipoHistoria;

	private ExamenFisicoEncriptacion examenFisico;

	private CiudadEntity ciudadHistoria;

	private List<HistoriaPreguntasGym> historiaPreguntasGyms;

	private List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity;

	private List<CondicionGymEntity> condicionGymEntity;

	private List<FamiliarGymEntity> familiarGymEntity;

	private List<CuestionarioGymEntity> cuestionarioGymEntity;

	private PersonaEntity persona;

	private Date diaHistoriaGym;

	private String observacionesHistoria;

	private String otraCondicion;

	private String otraFamiliar;

	private String tipoCancer;

	private String conducta;

	private String aceptoCondiciones;
	
	private Long personaMedico;

	public HistoriaGymEncriptacion() {
		this.historiaPreguntasGyms = new ArrayList<>();
		this.diagnosticoOcupacionalEntity = new ArrayList<>();
		this.condicionGymEntity = new ArrayList<>();
		this.familiarGymEntity = new ArrayList<>();
		this.diaHistoriaGym = new Date();
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

	public ExamenFisicoEncriptacion getExamenFisico() {
		return examenFisico;
	}

	public void setExamenFisico(ExamenFisicoEncriptacion examenFisico) {
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

	public List<CondicionGymEntity> getCondicionGymEntity() {
		return condicionGymEntity;
	}

	public void setCondicionGymEntity(List<CondicionGymEntity> condicionGymEntity) {
		this.condicionGymEntity = condicionGymEntity;
	}

	public List<FamiliarGymEntity> getFamiliarGymEntity() {
		return familiarGymEntity;
	}

	public void setFamiliarGymEntity(List<FamiliarGymEntity> familiarGymEntity) {
		this.familiarGymEntity = familiarGymEntity;
	}

	public List<CuestionarioGymEntity> getCuestionarioGymEntity() {
		return cuestionarioGymEntity;
	}

	public void setCuestionarioGymEntity(List<CuestionarioGymEntity> cuestionarioGymEntity) {
		this.cuestionarioGymEntity = cuestionarioGymEntity;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
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

	public String getOtraFamiliar() {
		return otraFamiliar;
	}

	public void setOtraFamiliar(String otraFamiliar) {
		this.otraFamiliar = otraFamiliar;
	}

	public String getTipoCancer() {
		return tipoCancer;
	}

	public void setTipoCancer(String tipoCancer) {
		this.tipoCancer = tipoCancer;
	}

	public String getConducta() {
		return conducta;
	}

	public void setConducta(String conducta) {
		this.conducta = conducta;
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
