package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	private Long seqPersona;

	@Column(name = "nom_primer_nombre", length = 50)
	private String nomPrimerNombre;

	@Column(name = "nom_primer_apellido", length = 50)
	private String nomPrimerApellido;

	@Column(name = "nom_segundo_nombre", length = 50)
	private String nomSegundoNombre;

	@Column(name = "nom_segundo_apellido", length = 50)
	private String nomSegundoApellido;

	@Column(name = "numero_documento", unique = true)
	private String numeroDocumento;

	@Column(name = "lic_salud")
	private String licenciaSalud;

	@Column(name = "registro_medico")
	private String registroMedico;

	@Column
	private Integer edad;

	@Column(length = 50)
	private String direccion;

	@Column
	private String telefono;

	@Column
	private String correo;

	@Column
	private String celular;

	@Column
	private String codigo;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Transient
	private String imagen;

	@Column(length = 10000)
	private byte[] imagenEncriptada;

	@Column
	private String genero;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "fecha_nacimiento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(length = 50)
	private String barrio;

	@Column(length = 50)
	private String escolaridad;

	@Column(name = "nom_cargo_dep")
	private String nomCargoDep;

	@Column(name = "afp_persona", length = 50, nullable = true)
	private String afp;

	@Column(name = "arl", length = 50)
	private String arl;

	@Column(name = "grupo_sanguineo", length = 50)
	private String grupoSanguineo;

	@Column(name = "rh", length = 50)
	private String rh;

	@Column(name = "tel_emergencia")
	private String telEmergencia;

	@Column(name = "nom_emergencia", length = 50)
	private String nomEmergencia;

	@Column(name = "parentesco_emergencia", length = 50)
	private String parentescoEmergencia;

	@ManyToOne
	@JoinColumn(name = "seq_lugar_nacimiento", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity lugarNacimiento;

	@Column(name = "seq_aseguradora", length = 100)
	private String aseguradora;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_documento", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoDocumentoEntity tipoDocumento;

	@ManyToOne
	@JoinColumn(name = "seq_localidad", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private LocalidadEntity localidad;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private List<HistoriaOcupacionalEntity> historiasEncriptacion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private List<HistoriaGYMEntity> historiaGymEncriptacion;

	@Transient
	private List<HistoriaOcupacionalEncriptacion> historias;

	@Transient
	private List<HistoriaGymEncriptacion> historiaGym;

	@ManyToOne
	@JoinColumn(name = "seq_perfil")
	private PerfilEntity perfil;

	@ManyToOne
	@JoinColumn(name = "seq_lugar_residencia", nullable = true)
	private CiudadEntity lugarDeResidencia;

	@ManyToMany
	@JoinTable(name = "hc_rol_usuario_persona", joinColumns = @JoinColumn(name = "seq_persona", unique = false, referencedColumnName = "seq_persona"), inverseJoinColumns = {
			@JoinColumn(name = "tipo_usuario", unique = false, referencedColumnName = "seq_tipo_usuario") }, indexes = {
					@Index(name = "my_index_name", columnList = "seq_persona", unique = false),
					@Index(name = "tipo_usuario", columnList = "tipo_usuario", unique = true) })
	private List<TipoUsuarioEntity> rolUsuario;

	@Column(name = "nuevo_rol_usuario")
	private String nuevorolUsuario;

	// nuevas colomnas 2021 enero
	@Column(name = "nombre_acompanante")
	private String nombreAcompanante;

	@Column(name = "telefono_acompanante")
	private String telefonoAcompanante;

	@Column(name = "nombre_persona_responsable")
	private String nombrePersonaResponsable;

	@Column(name = "telefono_persona_responsable")
	private String telefonoPersonaResponsable;

	@Column(name = "parentesco_persona_responsable")
	private String parentescoPersonaResponsable;

	@Column(name = "tipo_vinculacion")
	private String tipoVinculacion;

	@Column(name = "municipio_residencia")
	private String municipioResidencia;

	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
	}

	public PersonaEntity() {
		this.historias = new ArrayList<>();
		this.historiaGym = new ArrayList<>();
		this.rolUsuario = new ArrayList<>();
		this.historiasEncriptacion = new ArrayList<HistoriaOcupacionalEntity>();
		this.historiaGymEncriptacion = new ArrayList<HistoriaGYMEntity>();
	}

	public Long getSeqPersona() {
		return seqPersona;
	}

	public void setSeqPersona(Long seqPersona) {
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

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
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

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getArl() {
		return arl;
	}

	public void setArl(String arl) {
		this.arl = arl;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<TipoUsuarioEntity> getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(List<TipoUsuarioEntity> rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getNuevorolUsuario() {
		return nuevorolUsuario;
	}

	public void setNuevorolUsuario(String nuevorolUsuario) {
		this.nuevorolUsuario = nuevorolUsuario;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public byte[] getImagenEncriptada() {
		return imagenEncriptada;
	}

	public void setImagenEncriptada(byte[] imagenEncriptada) {
		this.imagenEncriptada = imagenEncriptada;
	}

	public String getLicenciaSalud() {
		return licenciaSalud;
	}

	public void setLicenciaSalud(String licenciaSalud) {
		this.licenciaSalud = licenciaSalud;
	}

	public String getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	public String getRegistroMedico() {
		return registroMedico;
	}

	public void setRegistroMedico(String registroMedico) {
		this.registroMedico = registroMedico;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

	public String getNombreAcompanante() {
		return nombreAcompanante;
	}

	public void setNombreAcompanante(String nombreAcompanante) {
		this.nombreAcompanante = nombreAcompanante;
	}

	public String getTelefonoAcompanante() {
		return telefonoAcompanante;
	}

	public void setTelefonoAcompanante(String telefonoAcompanante) {
		this.telefonoAcompanante = telefonoAcompanante;
	}

	public String getNombrePersonaResponsable() {
		return nombrePersonaResponsable;
	}

	public void setNombrePersonaResponsable(String nombrePersonaResponsable) {
		this.nombrePersonaResponsable = nombrePersonaResponsable;
	}

	public String getTelefonoPersonaResponsable() {
		return telefonoPersonaResponsable;
	}

	public void setTelefonoPersonaResponsable(String telefonoPersonaResponsable) {
		this.telefonoPersonaResponsable = telefonoPersonaResponsable;
	}

	public String getParentescoPersonaResponsable() {
		return parentescoPersonaResponsable;
	}

	public void setParentescoPersonaResponsable(String parentescoPersonaResponsable) {
		this.parentescoPersonaResponsable = parentescoPersonaResponsable;
	}

	public String getTipoVinculacion() {
		return tipoVinculacion;
	}

	public void setTipoVinculacion(String tipoVinculacion) {
		this.tipoVinculacion = tipoVinculacion;
	}

	public String getMunicipioResidencia() {
		return municipioResidencia;
	}

	public void setMunicipioResidencia(String municipioResidencia) {
		this.municipioResidencia = municipioResidencia;
	}

	public List<HistoriaOcupacionalEntity> getHistoriasEncriptacion() {
		return historiasEncriptacion;
	}

	public void setHistoriasEncriptacion(List<HistoriaOcupacionalEntity> historiasEncriptacion) {
		this.historiasEncriptacion = historiasEncriptacion;
	}

	public List<HistoriaGYMEntity> getHistoriaGymEncriptacion() {
		return historiaGymEncriptacion;
	}

	public void setHistoriaGymEncriptacion(List<HistoriaGYMEntity> historiaGymEncriptacion) {
		this.historiaGymEncriptacion = historiaGymEncriptacion;
	}

	public List<HistoriaOcupacionalEncriptacion> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaOcupacionalEncriptacion> historias) {
		this.historias = historias;
	}

	public List<HistoriaGymEncriptacion> getHistoriaGym() {
		return historiaGym;
	}

	public void setHistoriaGym(List<HistoriaGymEncriptacion> historiaGym) {
		this.historiaGym = historiaGym;
	}

}
