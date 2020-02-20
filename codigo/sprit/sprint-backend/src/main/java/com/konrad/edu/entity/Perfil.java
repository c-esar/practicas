package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hc_perfiles")
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_perfil")
	private Long seqPerfil;

	@Column(name = "nom_usuario", unique = true, length = 50)
	private String nomUsuario;

	@Column(name = "password", length = 50)
	private String password;

	private Boolean estado;

	@Column(name = "nom_perfil")
	private String nomPerfil;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "perfil_permisos", joinColumns = @JoinColumn(name = "seq_perfil"), inverseJoinColumns = @JoinColumn(name = "seq_permiso"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_perfil", "seq_permiso" }) })
	private List<Permisos> permisos;

	public Perfil(String string) {
		this.nomPerfil = string;
	}

	public Long getSeqPerfil() {
		return seqPerfil;
	}

	public void setSeqPerfil(Long seqPerfil) {
		this.seqPerfil = seqPerfil;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public List<Permisos> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permisos> permisos) {
		this.permisos = permisos;
	}

}