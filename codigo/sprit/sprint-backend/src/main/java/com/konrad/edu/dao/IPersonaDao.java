package com.konrad.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PersonaEntity;

public interface IPersonaDao extends CrudRepository<PersonaEntity, Long> {

	@Query(value = "select * from hc_personas u where u.numero_documento = ?1", nativeQuery = true)
	public PersonaEntity findByNumeroDocumento(@Param("numero_documento") String numero_documento);
	
	@Query(value = "select * from hc_personas u where u.seq_perfil = ?1", nativeQuery = true)
	public PersonaEntity findByNumeroPerfil(@Param("seq_perfil") String seq_perfil);
	
	@Query(value="SELECT DISTINCT p.seq_persona, p.nom_primer_nombre, "
			+ "p.nom_primer_apellido, p.numero_documento, p.celular FROM hc_personas AS p " + 
			"INNER JOIN hc_rol_usuario_persona as rol ON (rol.seq_persona=p.seq_persona) " + 
			"WHERE rol.seq_tipo_usuario IN (?1)", nativeQuery= true)
	public List<PersonaEntity> findAllTipoUsuario(@Param("seq_tipo_usuario") String seq_tipo_usuario);
	
}
