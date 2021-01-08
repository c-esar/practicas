package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaOcupacionalDao extends CrudRepository<HistoriaOcupacionalEntity, Long> {

	@Query(value = "ALTER TABLE hc_concepto_historia DROP CONSTRAINT seq_concepto", nativeQuery = true)
	public boolean alterConcepto();

	@Query(value = "ALTER TABLE hc_diagnostico_ocupacional_historia DROP CONSTRAINT seq_diagnostico", nativeQuery = true)
	public boolean alterdiagnostico();

	@Query(value = "SELECT * from hc_historia_ocupacional where seq_historia = ?1", nativeQuery = true)
	public HistoriaOcupacionalEntity FindBySeqHistoria(Long seqHistoria);
}
