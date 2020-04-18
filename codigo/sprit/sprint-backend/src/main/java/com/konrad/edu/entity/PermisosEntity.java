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
public class PermisosEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_permiso")
	private Long seqPermiso;

	@Column(name = "crear_usuario")
	@org.hibernate.annotations.ColumnDefault("0")
	private Long crearUsuario;

	@Column(name = "gestionar_usuario")
	@org.hibernate.annotations.ColumnDefault("0")
	private Long gestionarUsuario;

	@Column
	@org.hibernate.annotations.ColumnDefault("0")
	private Long descargar;

	@Column(name = "crear_aux")
	@org.hibernate.annotations.ColumnDefault("0")
	private Long crearAux;

	public Long getSeqPermiso() {
		return seqPermiso;
	}

	public void setSeqPermiso(Long seqPermiso) {
		this.seqPermiso = seqPermiso;
	}

	public Long getCrearUsuario() {
		return crearUsuario;
	}

	public void setCrearUsuario(Long crearUsuario) {
		this.crearUsuario = crearUsuario;
	}

	public Long getGestionarUsuario() {
		return gestionarUsuario;
	}

	public void setGestionarUsuario(Long gestionarUsuario) {
		this.gestionarUsuario = gestionarUsuario;
	}

	public Long getDescargar() {
		return descargar;
	}

	public void setDescargar(Long descargar) {
		this.descargar = descargar;
	}

	public Long getCrearAux() {
		return crearAux;
	}

	public void setCrearAux(Long crearAux) {
		this.crearAux = crearAux;
	}

}
