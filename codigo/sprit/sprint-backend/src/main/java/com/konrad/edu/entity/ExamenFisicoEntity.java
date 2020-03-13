package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_examen_fisico")
public class ExamenFisicoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_exa_fisico")
	private Long seqExaFisico;

	@Column(name = "num_tension")
	private double numTesion;

	@Column(name = "num_frec_car")
	private double numFreCar;

	@Column(name = "num_sat")
	private double numSat;

	@Column(name = "num_frec_resp")
	private double numFrecResp;

	@Column(name = "num_peso")
	private double numPeso;

	@Column(name = "num_talla")
	private double numTalla;

	@Column(name = "num_imc")
	private double numImc;

	@Column(name = "num_lateralidad")
	private double numLateralidad;

	@Column(name = "desp_cap_cuello", length = 4000)
	private String despCapCuello;

	@Column(name = "desp_torax", length = 4000)
	private String despTorax;

	@Column(name = "desp_adb", length = 4000)
	private String despAdb;

	@Column(name = "desp_genitourinario", length = 4000)
	private String despGenitourinario;

	@Column(name = "desp_column", length = 4000)
	private String despColumn;

	@Column(name = "desp_miembros", length = 4000)
	private String despMiembros;

	@Column(name = "desp_osteomuscular", length = 4000)
	private String despOsteomuscular;

	@Column(name = "desp_neurologico", length = 4000)
	private String despNeurologico;

	@Column(name = "desp_piel_fan", length = 4000)
	private String despPielfan;

	public Long getSeqExaFisico() {
		return seqExaFisico;
	}

	public void setSeqExaFisico(Long seqExaFisico) {
		this.seqExaFisico = seqExaFisico;
	}

	public double getNumTesion() {
		return numTesion;
	}

	public void setNumTesion(double numTesion) {
		this.numTesion = numTesion;
	}

	public double getNumFreCar() {
		return numFreCar;
	}

	public void setNumFreCar(double numFreCar) {
		this.numFreCar = numFreCar;
	}

	public double getNumSat() {
		return numSat;
	}

	public void setNumSat(double numSat) {
		this.numSat = numSat;
	}

	public double getNumFrecResp() {
		return numFrecResp;
	}

	public void setNumFrecResp(double numFrecResp) {
		this.numFrecResp = numFrecResp;
	}

	public double getNumPeso() {
		return numPeso;
	}

	public void setNumPeso(double numPeso) {
		this.numPeso = numPeso;
	}

	public double getNumTalla() {
		return numTalla;
	}

	public void setNumTalla(double numTalla) {
		this.numTalla = numTalla;
	}

	public double getNumImc() {
		return numImc;
	}

	public void setNumImc(double numImc) {
		this.numImc = numImc;
	}

	public double getNumLateralidad() {
		return numLateralidad;
	}

	public void setNumLateralidad(double numLateralidad) {
		this.numLateralidad = numLateralidad;
	}

	public String getDespCapCuello() {
		return despCapCuello;
	}

	public void setDespCapCuello(String despCapCuello) {
		this.despCapCuello = despCapCuello;
	}

	public String getDespTorax() {
		return despTorax;
	}

	public void setDespTorax(String despTorax) {
		this.despTorax = despTorax;
	}

	public String getDespAdb() {
		return despAdb;
	}

	public void setDespAdb(String despAdb) {
		this.despAdb = despAdb;
	}

	public String getDespGenitourinario() {
		return despGenitourinario;
	}

	public void setDespGenitourinario(String despGenitourinario) {
		this.despGenitourinario = despGenitourinario;
	}

	public String getDespColumn() {
		return despColumn;
	}

	public void setDespColumn(String despColumn) {
		this.despColumn = despColumn;
	}

	public String getDespMiembros() {
		return despMiembros;
	}

	public void setDespMiembros(String despMiembros) {
		this.despMiembros = despMiembros;
	}

	public String getDespOsteomuscular() {
		return despOsteomuscular;
	}

	public void setDespOsteomuscular(String despOsteomuscular) {
		this.despOsteomuscular = despOsteomuscular;
	}

	public String getDespNeurologico() {
		return despNeurologico;
	}

	public void setDespNeurologico(String despNeurologico) {
		this.despNeurologico = despNeurologico;
	}

	public String getDespPielfan() {
		return despPielfan;
	}

	public void setDespPielfan(String despPielfan) {
		this.despPielfan = despPielfan;
	}

}