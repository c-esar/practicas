package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PersonaEntity;

public interface IPersonaDao extends CrudRepository<PersonaEntity, Long> {

	@Query(value = "select * from hc_personas u where u.numero_documento = ?1", nativeQuery = true)
	public PersonaEntity findByNumeroDocumento(@Param("numero_documento") String numero_documento);
}
