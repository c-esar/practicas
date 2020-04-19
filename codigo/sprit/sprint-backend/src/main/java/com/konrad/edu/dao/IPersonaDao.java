package com.konrad.edu.dao;

import java.util.Collection;
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
	
	@Query(value="SELECT DISTINCT " + 
			"p.seq_persona, " + 
			"p.afp_persona, " + 
			"p.arl, " + 
			"p.barrio, " + 
			"p.celular, " + 
			"p.codigo, " + 
			"p.correo, " + 
			"p.direccion, " + 
			"p.edad, " + 
			"p.escolaridad, " + 
			"p.estado_civil, " + 
			"p.fecha_creacion, " + 
			"p.fecha_nacimiento, " + 
			"p.genero, " + 
			"p.grupo_sanguineo, " + 
			"p.nom_cargo_dep, " + 
			"p.nom_emergencia, " + 
			"p.nom_primer_apellido, " + 
			"p.nom_primer_nombre, " + 
			"p.nom_segundo_apellido, " + 
			"p.nom_segundo_nombre, " + 
			"p.nuevorol_usuario, " + 
			"p.numero_documento, " + 
			"p.parentesco_emergencia, " + 
			"p.rh, " + 
			"p.tel_emergencia, " + 
			"telefono, " + 
			"p.seq_aseguradora, " + 
			"p.seq_localidad, " + 
			"p.seq_lugar_residencia, " + 
			"p.seq_lugar_nacimiento, " + 
			"p.seq_perfil, " + 
			"p.seq_tipo_documento " + 
			"FROM hc_personas AS p " + 
			"INNER JOIN hc_rol_usuario_persona as rol ON (rol.seq_persona=p.seq_persona) " + 
			"WHERE rol.seq_tipo_usuario IN (:seq_tipo_usuario);" , nativeQuery = true)
	public List<PersonaEntity> findAllTipoUsuario(@Param("seq_tipo_usuario") List<String> seq_tipo_usuario);
	
}
