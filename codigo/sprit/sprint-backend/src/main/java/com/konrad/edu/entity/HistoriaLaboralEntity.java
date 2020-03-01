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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

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

	@Column(name = "nom_empresa")
	private String nomEmpresa;

	@Column(name = "act_economica")
	private String actEconomica;

	@Column(name = "dat_fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	@Column(name = "antiguedad")
	private String antiguedad;

	@Column(name = "cargo")
	private String cargo;

	@Column(name = "desp_funciones_cargo")
	private String desp_funciones_cargo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_laboral_empresa", joinColumns = @JoinColumn(name = "seq_historia_laboral"), inverseJoinColumns = @JoinColumn(name = "seq_empresa"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_laboral", "seq_empresa" }) })
	private List<EmpresaLaboralEntity> empresaLaboral;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_laboral_antTrabajo", joinColumns = @JoinColumn(name = "seq_historia_laboral"), inverseJoinColumns = @JoinColumn(name = "seq_ant"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_laboral", "seq_ant" }) })
	private List<AntecedentesTrabajoEntity> antecedentesTrabajo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_laboral_enfermedades", joinColumns = @JoinColumn(name = "seq_historia_laboral"), inverseJoinColumns = @JoinColumn(name = "seq_enfermedades_lab"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_laboral", "seq_enfermedades_lab" }) })
	private List<EnfermedadesLaboral> enfermedadesLaboral;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_laboral_factoresRiesgo", joinColumns = @JoinColumn(name = "seq_historia_laboral"), inverseJoinColumns = @JoinColumn(name = "seq_factores"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_laboral", "seq_factores" }) })
	private List<FactoresRiesgoEntity> factoresRiesgo;

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

	public String getDesp_funciones_cargo() {
		return desp_funciones_cargo;
	}

	public void setDesp_funciones_cargo(String desp_funciones_cargo) {
		this.desp_funciones_cargo = desp_funciones_cargo;
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

	public List<EnfermedadesLaboral> getEnfermedadesLaboral() {
		return enfermedadesLaboral;
	}

	public void setEnfermedadesLaboral(List<EnfermedadesLaboral> enfermedadesLaboral) {
		this.enfermedadesLaboral = enfermedadesLaboral;
	}

	public List<FactoresRiesgoEntity> getFactoresRiesgo() {
		return factoresRiesgo;
	}

	public void setFactoresRiesgo(List<FactoresRiesgoEntity> factoresRiesgo) {
		this.factoresRiesgo = factoresRiesgo;
	}

}