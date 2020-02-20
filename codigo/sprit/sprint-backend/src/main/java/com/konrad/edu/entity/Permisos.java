package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hc_permisos")
public class Permisos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seq_permiso")
	private Long seqPermiso;

	@Column(name = "crear_usuario")
	private String crearUsuario;

	@Column(name = "gestionar_usuario")
	private String gestionarUsuario;

	private String descargar;

	@Column(name = "crear_aux")
	private String crearAux;

	public Long getSeqPermiso() {
		return seqPermiso;
	}

	public void setSeqPermiso(Long seqPermiso) {
		this.seqPermiso = seqPermiso;
	}

	public String getCrearUsuario() {
		return crearUsuario;
	}

	public void setCrearUsuario(String crearUsuario) {
		this.crearUsuario = crearUsuario;
	}

	public String getGestionarUsuario() {
		return gestionarUsuario;
	}

	public void setGestionarUsuario(String gestionarUsuario) {
		this.gestionarUsuario = gestionarUsuario;
	}

	public String getDescargar() {
		return descargar;
	}

	public void setDescargar(String descargar) {
		this.descargar = descargar;
	}

	public String getCrearAux() {
		return crearAux;
	}

	public void setCrearAux(String crearAux) {
		this.crearAux = crearAux;
	}

}