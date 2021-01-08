package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_diagnostico")
public class DiagnosticoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_diagnostico")
	private Long seqDiagnostico;

	@Column(name = "cod_diagnostico")
	private String codDiagnostico;

	@Column(name = "sim_diagnostico")
	private String simDiagnostico;

	@Column(name = "des_diagnostico")
	private String desDiagnostico;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "lim_inferior")
	private String limInferior;

	@Column(name = "lim_superior")
	private String limSuperior;

	@Column(name = "afectacion_principal")
	private String afectacionPrincipal;

	@Column(name = "obser_diagnostico")
	private String obserDiagnostico;

	public Long getSeqDiagnostico() {
		return seqDiagnostico;
	}

	public void setSeqDiagnostico(Long seqDiagnostico) {
		this.seqDiagnostico = seqDiagnostico;
	}

	public String getCodDiagnostico() {
		return codDiagnostico;
	}

	public void setCodDiagnostico(String codDiagnostico) {
		this.codDiagnostico = codDiagnostico;
	}

	public String getSimDiagnostico() {
		return simDiagnostico;
	}

	public void setSimDiagnostico(String simDiagnostico) {
		this.simDiagnostico = simDiagnostico;
	}

	public String getDesDiagnostico() {
		return desDiagnostico;
	}

	public void setDesDiagnostico(String desDiagnostico) {
		this.desDiagnostico = desDiagnostico;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLimInferior() {
		return limInferior;
	}

	public void setLimInferior(String limInferior) {
		this.limInferior = limInferior;
	}

	public String getLimSuperior() {
		return limSuperior;
	}

	public void setLimSuperior(String limSuperior) {
		this.limSuperior = limSuperior;
	}

	public String getAfectacionPrincipal() {
		return afectacionPrincipal;
	}

	public void setAfectacionPrincipal(String afectacionPrincipal) {
		this.afectacionPrincipal = afectacionPrincipal;
	}

	public String getObserDiagnostico() {
		return obserDiagnostico;
	}

	public void setObserDiagnostico(String obserDiagnostico) {
		this.obserDiagnostico = obserDiagnostico;
	}

}
