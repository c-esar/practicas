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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_historia_gym")
public class HistoriaGYMEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "seq_historia_gym")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqHistoriaGym;

	@ManyToOne
	@JoinColumn(name = "seq_tipo_historia")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoHistoriasEntity seqTipoHistoria;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "seq_exa_fisico", unique = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenFisicoEntity examenFisico;


	@ManyToOne
	@JoinColumn(name = "seq_ciudad", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CiudadEntity ciudadHistoria;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_gym")
	private List<HistoriaPreguntasGym> historiaPreguntasGyms;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_diagnosticoGym_historia", joinColumns = @JoinColumn(name = "seq_historia_gym"), inverseJoinColumns = @JoinColumn(name = "seq_diagnostico"), indexes = {
			@Index(name = "seq_historia_gym", columnList = "seq_historia_gym", unique = false),
			@Index(name = "seq_diagnostico", columnList = "seq_diagnostico", unique = true) })
	private List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_condiciones_historiaGym", joinColumns = @JoinColumn(name = "seq_historia_gym", unique = false), 
			inverseJoinColumns = @JoinColumn(name = "seq_condicion_gym", unique = false), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_gym", "seq_condicion_gym" }) },
			indexes = {@Index(name = "seq_historia_gym",  columnList="seq_historia_gym", unique = false),
            @Index(name = "seq_condicion_gym", columnList="seq_condicion_gym",     unique = true)})
	private List<CondicionGymEntity> condicionGymEntity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hc_familiar_historiaGym", joinColumns = @JoinColumn(name = "seq_historia_gym", unique = false), 
			inverseJoinColumns = @JoinColumn(name = "seq_familiar_gym", unique = false), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "seq_historia_gym", "seq_familiar_gym" })}, 
			indexes = {@Index(name = "seq_historia_gym",  columnList="seq_historia_gym", unique = false),
              @Index(name = "seq_familiar_gym", columnList="seq_familiar_gym",     unique = true)})
	private List<FamiliarGymEntity> familiarGymEntity;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_historia_gym")
	private List<CuestionarioGymEntity> cuestionarioGymEntity;
	
	@ManyToOne
	@JoinColumn(name = "seq_persona")
	private PersonaEntity persona;
	
	private Long personaMedico;

	@Column(name = "dia_historia_gym")
	@Temporal(TemporalType.DATE)
	private Date diaHistoriaGym;

	@Column(name = "observaciones_historia")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',observaciones_historia)")
	private byte[] observacionesHistoria;

	@Column(name = "otra_condicion")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',otra_condicion)")
	private byte[] otraCondicion;
	
	@Column(name="otra_familiar")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',otra_familiar)")
	private byte[] otraFamiliar;
	
	@Column(name="tipo_cancer")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',tipo_cancer)")
	private byte[] tipoCancer;

	@Column(name = "conducta")
	@ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('konradU',?)", read = "DECRYPTBYPASSPHRASE('konradU',conducta)")
	private byte[] conducta;

	@Column()
	private String aceptoCondiciones;

	@PrePersist
	public void prePersist() {
		this.diaHistoriaGym = new Date();
	}
	
	public HistoriaGYMEntity() {
		this.historiaPreguntasGyms = new ArrayList<>();
		this.diagnosticoOcupacionalEntity = new ArrayList<>();
		this.condicionGymEntity = new ArrayList<>();
		this.familiarGymEntity = new ArrayList<>();
	}


	public Long getSeqHistoriaGym() {
		return seqHistoriaGym;
	}


	public void setSeqHistoriaGym(Long seqHistoriaGym) {
		this.seqHistoriaGym = seqHistoriaGym;
	}


	public TipoHistoriasEntity getSeqTipoHistoria() {
		return seqTipoHistoria;
	}


	public void setSeqTipoHistoria(TipoHistoriasEntity seqTipoHistoria) {
		this.seqTipoHistoria = seqTipoHistoria;
	}


	public ExamenFisicoEntity getExamenFisico() {
		return examenFisico;
	}


	public void setExamenFisico(ExamenFisicoEntity examenFisico) {
		this.examenFisico = examenFisico;
	}


	public CiudadEntity getCiudadHistoria() {
		return ciudadHistoria;
	}


	public void setCiudadHistoria(CiudadEntity ciudadHistoria) {
		this.ciudadHistoria = ciudadHistoria;
	}


	public List<HistoriaPreguntasGym> getHistoriaPreguntasGyms() {
		return historiaPreguntasGyms;
	}


	public void setHistoriaPreguntasGyms(List<HistoriaPreguntasGym> historiaPreguntasGyms) {
		this.historiaPreguntasGyms = historiaPreguntasGyms;
	}


	public List<DiagnosticoOcupacionalEntity> getDiagnosticoOcupacionalEntity() {
		return diagnosticoOcupacionalEntity;
	}


	public void setDiagnosticoOcupacionalEntity(List<DiagnosticoOcupacionalEntity> diagnosticoOcupacionalEntity) {
		this.diagnosticoOcupacionalEntity = diagnosticoOcupacionalEntity;
	}


	public Date getDiaHistoriaGym() {
		return diaHistoriaGym;
	}


	public void setDiaHistoriaGym(Date diaHistoriaGym) {
		this.diaHistoriaGym = diaHistoriaGym;
	}


	public byte[] getObservacionesHistoria() {
		return observacionesHistoria;
	}


	public void setObservacionesHistoria(byte[] observacionesHistoria) {
		this.observacionesHistoria = observacionesHistoria;
	}	

	public List<CuestionarioGymEntity> getCuestionarioGymEntity() {
		return cuestionarioGymEntity;
	}


	public void setCuestionarioGymEntity(List<CuestionarioGymEntity> cuestionarioGymEntity) {
		this.cuestionarioGymEntity = cuestionarioGymEntity;
	}


	public List<CondicionGymEntity> getCondicionGymEntity() {
		return condicionGymEntity;
	}


	public void setCondicionGymEntity(List<CondicionGymEntity> condicionGymEntity) {
		this.condicionGymEntity = condicionGymEntity;
	}


	public List<FamiliarGymEntity> getFamiliarGymEntity() {
		return familiarGymEntity;
	}


	public void setFamiliarGymEntity(List<FamiliarGymEntity> familiarGymEntity) {
		this.familiarGymEntity = familiarGymEntity;
	}


	public PersonaEntity getPersona() {
		return persona;
	}


	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}


	public String getAceptoCondiciones() {
		return aceptoCondiciones;
	}


	public void setAceptoCondiciones(String aceptoCondiciones) {
		this.aceptoCondiciones = aceptoCondiciones;
	}


	public byte[] getOtraCondicion() {
		return otraCondicion;
	}


	public void setOtraCondicion(byte[] otraCondicion) {
		this.otraCondicion = otraCondicion;
	}


	public byte[] getOtraFamiliar() {
		return otraFamiliar;
	}


	public void setOtraFamiliar(byte[] otraFamiliar) {
		this.otraFamiliar = otraFamiliar;
	}


	public byte[] getTipoCancer() {
		return tipoCancer;
	}


	public void setTipoCancer(byte[] tipoCancer) {
		this.tipoCancer = tipoCancer;
	}


	public byte[] getConducta() {
		return conducta;
	}


	public void setConducta(byte[] conducta) {
		this.conducta = conducta;
	}

	public Long getPersonaMedico() {
		return personaMedico;
	}

	public void setPersonaMedico(Long personaMedico) {
		this.personaMedico = personaMedico;
	}


	
	
}
