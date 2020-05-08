package com.konrad.edu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Lob
	@Column(name = "imagen")
	private String imagen;

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

	@Column(name="afp_persona", length = 50, nullable= true)
	private String afp;

	@Column(length = 50)
	private String arl;

	@Column(name = "grupo_sanguineo", length = 50)
	private String grupoSanguineo;

	@Column(length = 50)
	private String rh;

	@Column(name = "tel_emergencia")
	private String telEmergencia;

	@Column(name = "nom_emergencia", length = 50)
	private String nomEmergencia;

	@Column(name = "parentesco_emergencia", length = 50)
	private String parentescoEmergencia;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "hc_persona_historia", joinColumns = @JoinColumn(name = "seq_persona"), inverseJoinColumns = @JoinColumn(name = "seq_historia"), uniqueConstraints = {
//			@UniqueConstraint(columnNames = { "seq_persona", "seq_historia" }) })

	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
	}

	@ManyToOne
	@JoinColumn(name = "seq_lugar_nacimiento", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity lugarNacimiento;

	@ManyToOne
	@JoinColumn(name = "seq_aseguradora", nullable= true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AseguradoraEntity aseguradora;

	@ManyToOne
	@JoinColumn(name = "seq_localidad", nullable= true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private LocalidadEntity localidad;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_documento", nullable= true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoDocumentoEntity tipoDocumento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="persona")
	private List<HistoriaOcupacionalEntity> historias;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="persona")
	private List<HistoriaGYMEntity> historiaGym;
	
	@ManyToOne
	@JoinColumn(name = "seq_perfil")
	private PerfilEntity perfil;

	@ManyToOne
	@JoinColumn(name = "seq_lugar_residencia", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity lugarDeResidencia;
	
	@OneToMany
	@JoinTable(name = "hc_rol_usuario_persona", joinColumns = @JoinColumn(name = "seq_persona"), inverseJoinColumns = @JoinColumn(name = "seq_tipo_usuario"))
	private List<TipoUsuarioEntity> rolUsuario;
	
	@Column
	private String nuevorolUsuario;
	
	public PersonaEntity() {
		this.historias = new ArrayList<>();
		this.historiaGym = new ArrayList<>();
		this.rolUsuario = new ArrayList<>();
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

	public List<HistoriaOcupacionalEntity> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaOcupacionalEntity> historias) {
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

	public List<HistoriaGYMEntity> getHistoriasGym() {
		return historiaGym;
	}

	public void setHistoriasGym(List<HistoriaGYMEntity> historiaGym) {
		this.historiaGym = historiaGym;
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

	public List<HistoriaGYMEntity> getHistoriaGym() {
		return historiaGym;
	}

	public void setHistoriaGym(List<HistoriaGYMEntity> historiaGym) {
		this.historiaGym = historiaGym;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
