package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "hc_personas")
public class PersonaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_persona")
	private Integer seqPersona;

	@Column(name = "nom_primer_nombre")
	private String nomPrimerNombre;

	@Column(name = "nom_primer_apellido")
	private String nomPrimerApellido;

	@Column(name = "nom_segundo_nombre")
	private String nomSegundoNombre;

	@Column(name = "nom_segundo_apellido")
	private String nomSegundoApellido;

	@OneToOne
	@JoinColumn(name = "seq_tipo_documento", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoDocumentoEntity tipoDocumento;

	@Column(name = "numero_documento")
	private String numeroDocumento;

	@Column
	private Integer edad;

	@Column
	private String direccion;

	@Column
	private String telefono;

	@Column
	private String correo;

	@Column
	private String celular;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	// falta deinir firma

	@Column
	private String genero;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@OneToOne
	@JoinColumn(name = "seq_lugarNacimiento", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity lugarNacimiento;

	@Column
	private String barrio;

	@OneToOne
	@JoinColumn(name = "seq_lugarResidencia", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity lugarDeResidencia;

	@Column
	private String escolaridad;

	@Column(name = "nom_cargo_dep")
	private String nomCargoDep;

	@Column
	private String AFP;

	@Column
	private String ARL;

	@Column(name = "grupo_sanguineo")
	private String grupoSanguineo;

	@Column
	private String RH;

	@Column(name = "tel_emergencia")
	private String telEmergencia;

	@Column(name = "nom_emergencia")
	private String nomEmergencia;

	@Column(name = "parentesco_emergencia")
	private String parentescoEmergencia;

	@OneToOne
	@JoinColumn(name = "seq_aseguradora", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AseguradoraEntity aseguradora;

	@OneToOne
	@JoinColumn(name = "seq_localidad", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private LocalidadEntity localidad;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "hc_persona_historia", joinColumns = @JoinColumn(name = "seq_persona"), inverseJoinColumns = @JoinColumn(name = "seq_historia"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_persona", "seq_historia" }) })
	private List<HistoriasEntity> historias;

	private String rolUsuario;

	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
	}

	public Integer getSeqPersona() {
		return seqPersona;
	}

	public void setSeqPersona(Integer seqPersona) {
		this.seqPersona = seqPersona;
	}

	public String getNomPrimerNombre() {
		return nomPrimerNombre;
	}

	public void setNomPrimerNombre(String nomPrimerNombre) {
		this.nomPrimerNombre = nomPrimerNombre;
	}

	public String getNomPrimerApellido() {
		return nomPrimerApellido;
	}

	public void setNomPrimerApellido(String nomPrimerApellido) {
		this.nomPrimerApellido = nomPrimerApellido;
	}

	public String getNomSegundoNombre() {
		return nomSegundoNombre;
	}

	public void setNomSegundoNombre(String nomSegundoNombre) {
		this.nomSegundoNombre = nomSegundoNombre;
	}

	public String getNomSegundoApellido() {
		return nomSegundoApellido;
	}

	public void setNomSegundoApellido(String nomSegundoApellido) {
		this.nomSegundoApellido = nomSegundoApellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getNomCargoDep() {
		return nomCargoDep;
	}

	public void setNomCargoDep(String nomCargoDep) {
		this.nomCargoDep = nomCargoDep;
	}

	public String getAFP() {
		return AFP;
	}

	public void setAFP(String aFP) {
		AFP = aFP;
	}

	public String getARL() {
		return ARL;
	}

	public void setARL(String aRL) {
		ARL = aRL;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getRH() {
		return RH;
	}

	public void setRH(String rH) {
		RH = rH;
	}

	public String getTelEmergencia() {
		return telEmergencia;
	}

	public void setTelEmergencia(String telEmergencia) {
		this.telEmergencia = telEmergencia;
	}

	public String getNomEmergencia() {
		return nomEmergencia;
	}

	public void setNomEmergencia(String nomEmergencia) {
		this.nomEmergencia = nomEmergencia;
	}

	public String getParentescoEmergencia() {
		return parentescoEmergencia;
	}

	public void setParentescoEmergencia(String parentescoEmergencia) {
		this.parentescoEmergencia = parentescoEmergencia;
	}

	public AseguradoraEntity getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(AseguradoraEntity aseguradora) {
		this.aseguradora = aseguradora;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

	public List<HistoriasEntity> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriasEntity> historias) {
		this.historias = historias;
	}

	public CiudadEntity getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(CiudadEntity lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public CiudadEntity getLugarDeResidencia() {
		return lugarDeResidencia;
	}

	public void setLugarDeResidencia(CiudadEntity lugarDeResidencia) {
		this.lugarDeResidencia = lugarDeResidencia;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

}