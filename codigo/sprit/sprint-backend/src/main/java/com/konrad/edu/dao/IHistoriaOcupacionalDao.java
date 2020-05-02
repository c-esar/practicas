package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaOcupacionalDao extends CrudRepository<HistoriaOcupacionalEntity, Long> {

	@Query(value = "select * from hc_historia_ocupacional u " + 
			"inner join hc_personas p on p.seq_persona = u.seq_persona " + 
			"where p.numero_documento = ?1 ", nativeQuery = true)
	public HistoriaOcupacionalEntity findByPersona(@Param("documento") String id);
}
