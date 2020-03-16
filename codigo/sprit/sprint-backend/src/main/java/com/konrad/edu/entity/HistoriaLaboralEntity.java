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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hc_historia_laboral")
public class HistoriaLaboralEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_historia_laboral")
	private Long seqHistoriaLaboral;

	@Column(name = "nom_empresa", length = 50)
	private String nomEmpresa;

	@Column(name = "act_economica", length = 50)
	private String actEconomica;

	@Column(name = "dat_fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	@Column(name = "antiguedad", length = 50)
	private String antiguedad;

	@Column(name = "cargo", length = 50)
	private String cargo;

	@Column(name = "desp_funciones_cargo", length = 4000)
	@Lob
	private String desp_funciones_cargo;

	@Column(name = "acciones_trabajo_SN", length = 2)
	private String accionesTrabajoSN;

	@Column(name = "enfermedad_laboral_SN", length = 2)
	private String enfermedadLaboralSN;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<EmpresaLaboralEntity> empresaLaboral;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<AntecedentesTrabajoEntity> antecedentesTrabajo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<EnfermedadesLaboralEntity> enfermedadesLaboral;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_laboral")
	private List<FactoresRiesgoEntity> factoresRiesgo;

	public HistoriaLaboralEntity() {
		this.antecedentesTrabajo = new ArrayList<>();
		this.enfermedadesLaboral = new ArrayList<>();
		this.factoresRiesgo = new ArrayList<>();
		this.empresaLaboral = new ArrayList<>();
	}

	public Long getSeqHistoriaLaboral() {
		return seqHistoriaLaboral;
	}

	public void setSeqHistoriaLaboral(Long seqHistoriaLaboral) {
		this.seqHistoriaLaboral = seqHistoriaLaboral;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public String getActEconomica() {
		return actEconomica;
	}

	public void setActEconomica(String actEconomica) {
		this.actEconomica = actEconomica;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<EmpresaLaboralEntity> getEmpresaLaboral() {
		return empresaLaboral;
	}

	public void setEmpresaLaboral(List<EmpresaLaboralEntity> empresaLaboral) {
		this.empresaLaboral = empresaLaboral;
	}

	public List<AntecedentesTrabajoEntity> getAntecedentesTrabajo() {
		return antecedentesTrabajo;
	}

	public void setAntecedentesTrabajo(List<AntecedentesTrabajoEntity> antecedentesTrabajo) {
		this.antecedentesTrabajo = antecedentesTrabajo;
	}

	public List<EnfermedadesLaboralEntity> getEnfermedadesLaboral() {
		return enfermedadesLaboral;
	}

	public void setEnfermedadesLaboral(List<EnfermedadesLaboralEntity> enfermedadesLaboral) {
		this.enfermedadesLaboral = enfermedadesLaboral;
	}

	public List<FactoresRiesgoEntity> getFactoresRiesgo() {
		return factoresRiesgo;
	}

	public void setFactoresRiesgo(List<FactoresRiesgoEntity> factoresRiesgo) {
		this.factoresRiesgo = factoresRiesgo;
	}

	public String getDesp_funciones_cargo() {
		return desp_funciones_cargo;
	}

	public void setDesp_funciones_cargo(String desp_funciones_cargo) {
		this.desp_funciones_cargo = desp_funciones_cargo;
	}

	public String getAccionesTrabajoSN() {
		return accionesTrabajoSN;
	}

	public void setAccionesTrabajoSN(String accionesTrabajoSN) {
		this.accionesTrabajoSN = accionesTrabajoSN;
	}

	public String getEnfermedadLaboralSN() {
		return enfermedadLaboralSN;
	}

	public void setEnfermedadLaboralSN(String enfermedadLaboralSN) {
		this.enfermedadLaboralSN = enfermedadLaboralSN;
	}

}
