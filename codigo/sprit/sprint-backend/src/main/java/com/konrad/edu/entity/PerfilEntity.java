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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

	private String estado;

	@Column(name = "nom_perfil")
	private String nomPerfil;

	@OneToOne
	@JoinColumn(name = "seq_persona", updatable = false, nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PersonaEntity persona;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_perfil_permisos", joinColumns = @JoinColumn(name = "seq_perfil"), inverseJoinColumns = @JoinColumn(name = "seq_permiso"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_perfil", "seq_permiso" }) })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<PermisosEntity> permisos;

//	public PerfilEntity(PerfilEntity perfilEntity) {
//		this.seqPerfil = perfilEntity.getSeqPerfil();
//		this.nomUsuario = perfilEntity.getNomUsuario();
//		this.password = perfilEntity.getPassword();
//		this.estado = perfilEntity.getEstado();
//		this.nomPerfil = perfilEntity.getNomPerfil();
//		this.persona = new PersonaEntity(perfilEntity.getPersona());
//	}

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

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	@Override
	public String toString() {
		return "PerfilEntity [seqPerfil=" + seqPerfil + ", nomUsuario=" + nomUsuario + ", password=" + password
				+ ", estado=" + estado + ", nomPerfil=" + nomPerfil + ", persona=" + persona + ", permisos=" + permisos
				+ "]";
	}

	public List<PermisosEntity> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisosEntity> permisos) {
		this.permisos = permisos;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

}