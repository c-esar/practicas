package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_perfiles")
public class PerfilEntity implements Serializable {

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

	@Column
	private String estado;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "perfil")
	private List<PersonaEntity> persona;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_perfil_permisos", joinColumns = @JoinColumn(name = "seq_perfil"), inverseJoinColumns = @JoinColumn(name = "seq_permiso"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_perfil", "seq_permiso" }) })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<PermisosEntity> permisos;
	
	public PerfilEntity() {
		this.persona = new ArrayList<>();
		this.permisos = new ArrayList<>();
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PermisosEntity> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisosEntity> permisos) {
		this.permisos = permisos;
	}

	public List<PersonaEntity> getPersona() {
		return persona;
	}

	public void setPersona(List<PersonaEntity> persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "PerfilEntity [seqPerfil=" + seqPerfil + ", nomUsuario=" + nomUsuario + ", password=" + password
				+ ", estado=" + estado + ", persona=" + persona + ", permisos=" + permisos + "]";
	}
	
}
