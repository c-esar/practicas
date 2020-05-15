package com.konrad.edu.entity;

import java.io.Serializable;


public class ExamenFisicoEncriptacion implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long seqExaFisico;
	private double numTesion;
	private double numFreCar;
	private double numSat;
	private double numFrecResp;
	private double numPeso;
	private double numTalla;
	private double numImc;
	private String lateralidad;
	private String despCapCuello;
	private String despTorax;
	private String despAdb;
	private String despGenitourinario;
	private String despColumn;
	private String despMiembros;
	private String despOsteomuscular;
	private String despNeurologico;
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

	public String getLateralidad() {
		return lateralidad;
	}

	public void setLateralidad(String lateralidad) {
		this.lateralidad = lateralidad;
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
