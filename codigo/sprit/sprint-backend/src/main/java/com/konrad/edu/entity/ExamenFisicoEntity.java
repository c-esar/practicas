package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

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
	private String numTesion;

	@Column(name = "num_frec_car")
	private String numFreCar;

	@Column(name = "num_sat")
	private String numSat;

	@Column(name = "num_frec_resp")
	private String numFrecResp;

	@Column(name = "num_peso")
	private String numPeso;

	@Column(name = "num_talla")
	private String numTalla;

	@Column(name = "num_imc")
	private String numImc;

	@Column(name = "lateralidad")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',lateralidad)")
	private byte[] lateralidad;

	@Column(name = "desp_cap_cuello", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_cap_cuello)")
	private byte[] despCapCuello;

	@Column(name = "desp_torax", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_torax)")
	private byte[] despTorax;

	@Column(name = "desp_adb", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_adb)")
	private byte[] despAdb;

	@Column(name = "desp_genitourinario", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_genitourinario)")
	private byte[] despGenitourinario;

	@Column(name = "desp_column", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_column)")
	private byte[] despColumn;

	@Column(name = "desp_miembros", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_miembros)")
	private byte[] despMiembros;

	@Column(name = "desp_osteomuscular", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_osteomuscular)")
	private byte[] despOsteomuscular;

	@Column(name = "desp_neurologico", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_neurologico)")
	private byte[] despNeurologico;

	@Column(name = "desp_piel_fan", length = 4000)
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',desp_piel_fan)")
	private byte[] despPielfan;

	public Long getSeqExaFisico() {
		return seqExaFisico;
	}

	public void setSeqExaFisico(Long seqExaFisico) {
		this.seqExaFisico = seqExaFisico;
	}

	

	public String getNumTesion() {
		return numTesion;
	}

	public void setNumTesion(String numTesion) {
		this.numTesion = numTesion;
	}

	public String getNumFreCar() {
		return numFreCar;
	}

	public void setNumFreCar(String numFreCar) {
		this.numFreCar = numFreCar;
	}

	public String getNumSat() {
		return numSat;
	}

	public void setNumSat(String numSat) {
		this.numSat = numSat;
	}

	public String getNumFrecResp() {
		return numFrecResp;
	}

	public void setNumFrecResp(String numFrecResp) {
		this.numFrecResp = numFrecResp;
	}

	public String getNumPeso() {
		return numPeso;
	}

	public void setNumPeso(String numPeso) {
		this.numPeso = numPeso;
	}

	public String getNumTalla() {
		return numTalla;
	}

	public void setNumTalla(String numTalla) {
		this.numTalla = numTalla;
	}

	public String getNumImc() {
		return numImc;
	}

	public void setNumImc(String numImc) {
		this.numImc = numImc;
	}

	public byte[] getLateralidad() {
		return lateralidad;
	}

	public void setLateralidad(byte[] lateralidad) {
		this.lateralidad = lateralidad;
	}

	public byte[] getDespCapCuello() {
		return despCapCuello;
	}

	public void setDespCapCuello(byte[] despCapCuello) {
		this.despCapCuello = despCapCuello;
	}

	public byte[] getDespTorax() {
		return despTorax;
	}

	public void setDespTorax(byte[] despTorax) {
		this.despTorax = despTorax;
	}

	public byte[] getDespAdb() {
		return despAdb;
	}

	public void setDespAdb(byte[] despAdb) {
		this.despAdb = despAdb;
	}

	public byte[] getDespGenitourinario() {
		return despGenitourinario;
	}

	public void setDespGenitourinario(byte[] despGenitourinario) {
		this.despGenitourinario = despGenitourinario;
	}

	public byte[] getDespColumn() {
		return despColumn;
	}

	public void setDespColumn(byte[] despColumn) {
		this.despColumn = despColumn;
	}

	public byte[] getDespMiembros() {
		return despMiembros;
	}

	public void setDespMiembros(byte[] despMiembros) {
		this.despMiembros = despMiembros;
	}

	public byte[] getDespOsteomuscular() {
		return despOsteomuscular;
	}

	public void setDespOsteomuscular(byte[] despOsteomuscular) {
		this.despOsteomuscular = despOsteomuscular;
	}

	public byte[] getDespNeurologico() {
		return despNeurologico;
	}

	public void setDespNeurologico(byte[] despNeurologico) {
		this.despNeurologico = despNeurologico;
	}

	public byte[] getDespPielfan() {
		return despPielfan;
	}

	public void setDespPielfan(byte[] despPielfan) {
		this.despPielfan = despPielfan;
	}

}
