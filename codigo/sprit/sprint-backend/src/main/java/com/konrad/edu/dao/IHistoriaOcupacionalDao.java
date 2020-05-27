package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;
import com.konrad.edu.entity.PersonaEntity;

public interface IHistoriaOcupacionalDao extends CrudRepository<HistoriaOcupacionalEntity, Long> {

	@Query(value = "ALTER TABLE hc_concepto_historia DROP CONSTRAINT seq_concepto", nativeQuery = true)
	public boolean alterConcepto();
	
	@Query(value = "ALTER TABLE hc_diagnostico_ocupacional_historia DROP CONSTRAINT seq_diagnostico", nativeQuery = true)
	public boolean alterdiagnostico();
}
