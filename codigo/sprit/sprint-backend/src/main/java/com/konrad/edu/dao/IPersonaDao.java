package com.konrad.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PerfilEntity;
import com.konrad.edu.entity.PersonaEntity;
import com.konrad.edu.entity.TipoDocumentoEntity;

public interface IPersonaDao extends CrudRepository<PersonaEntity, Long> {

	@Query(value = "select * from hc_personas u where u.numero_documento = ?1 and u.rol_usuario = 'Paciente'", nativeQuery = true)
	public PersonaEntity findByNumeroDocumento(@Param("numero_documento") String numero_documento);
}
