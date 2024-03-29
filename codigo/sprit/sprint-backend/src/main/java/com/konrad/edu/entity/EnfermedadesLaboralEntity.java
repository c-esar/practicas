
package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hc_enfermedades_laborales")
public class EnfermedadesLaboralEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_enfermedades_lab")
	private Long seqEnfermedadesLab;

	@Column(name = "dat_fecha_ant")
	private Date fechaAnt;

	@Column(name = "nom_empresa", length = 100)
	private String nomEmpresa;

	@Column(name = "desp_diagnostico", length = 4000)
	private String despDiagnostico;

	@Column(name = "desp_recomendaciones", length = 4000)
	private String despRecomendaciones;

	@Column(name = "desp_indemnizar", length = 100)
	private String despIndemnizar;

	public Long getSeqEnfermedadesLab() {
		return seqEnfermedadesLab;
	}

	public void setSeqEnfermedadesLab(Long seqEnfermedadesLab) {
		this.seqEnfermedadesLab = seqEnfermedadesLab;
	}

	public Date getFechaAnt() {
		return fechaAnt;
	}

	public void setFechaAnt(Date fechaAnt) {
		this.fechaAnt = fechaAnt;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public String getDespIndemnizar() {
		return despIndemnizar;
	}

	public void setDespIndemnizar(String despIndemnizar) {
		this.despIndemnizar = despIndemnizar;
	}

	public String getDespDiagnostico() {
		return despDiagnostico;
	}

	public void setDespDiagnostico(String despDiagnostico) {
		this.despDiagnostico = despDiagnostico;
	}

	public String getDespRecomendaciones() {
		return despRecomendaciones;
	}

	public void setDespRecomendaciones(String despRecomendaciones) {
		this.despRecomendaciones = despRecomendaciones;
	}
}
