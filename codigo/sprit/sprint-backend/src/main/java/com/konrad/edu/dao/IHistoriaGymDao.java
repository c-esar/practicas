package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.PersonaEntity;

public interface IHistoriaGymDao extends CrudRepository<HistoriaGYMEntity, Long>{

	@Query(value = "select * from hc_historia_gym u " + 
			"inner join hc_personas p on p.seq_persona = u.seq_persona " + 
			"where p.numero_documento = ?1 ", nativeQuery = true)
	public HistoriaGYMEntity findByPersona(@Param("documento") String id);
}
