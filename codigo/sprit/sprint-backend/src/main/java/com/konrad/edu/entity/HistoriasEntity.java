package com.konrad.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hc_historias")
public class HistoriasEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "seq_historia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqHistoria;

	@OneToOne
	@JoinColumn(name = "seq_tipo_historia", updatable = false, nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoHistorias seqTipoHistoria;

	@OneToOne
	@JoinColumn(name = "seq_historia_laboral", updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private HistoriaLaboralEntity historiaLaboral;

	public Long getSeqHistoria() {
		return seqHistoria;
	}

	public void setSeqHistoria(Long seqHistoria) {
		this.seqHistoria = seqHistoria;
	}

	public TipoHistorias getSeqTipoHistoria() {
		return seqTipoHistoria;
	}

	public void setSeqTipoHistoria(TipoHistorias seqTipoHistoria) {
		this.seqTipoHistoria = seqTipoHistoria;
	}

	public HistoriaLaboralEntity getHistoriaLaboral() {
		return historiaLaboral;
	}

	public void setHistoriaLaboral(HistoriaLaboralEntity historiaLaboral) {
		this.historiaLaboral = historiaLaboral;
	}

}