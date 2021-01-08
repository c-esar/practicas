package com.konrad.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PersonaEntity;

public interface IPersonaDao extends CrudRepository<PersonaEntity, Long> {

	@Query(value = "  select * from hc_personas u "
			+ "  left outer join hc_historia_ocupacional hho on u.seq_persona = hho.seq_persona "
			+ "  left outer join hc_historia_gym hhg on u.seq_persona = hhg.seq_persona "
			+ "  where u.numero_documento = ?1", nativeQuery = true)
	public PersonaEntity findByNumeroDocumento(@Param("numero_documento") String numero_documento);

	@Query(value = "select * from hc_personas u where u.seq_perfil = ?1", nativeQuery = true)
	public PersonaEntity findByNumeroPerfil(@Param("seq_perfil") String seq_perfil);

	@Query(value = "SELECT DISTINCT " + "p.seq_persona, " + "p.afp_persona, " + "p.arl, " + "p.barrio, " + "p.celular, "
			+ "p.codigo, " + "p.correo, " + "p.direccion, " + "p.edad, " + "p.escolaridad, " + "p.estado_civil, "
			+ "p.fecha_creacion, " + "p.fecha_nacimiento, " + "p.genero, " + "p.grupo_sanguineo, " + "p.nom_cargo_dep, "
			+ "p.nom_emergencia, " + "p.nom_primer_apellido, " + "p.nom_primer_nombre, " + "p.nom_segundo_apellido, "
			+ "p.nom_segundo_nombre, " + "p.nuevo_rol_usuario, " + "p.numero_documento, " + "p.parentesco_emergencia, "
			+ "p.rh, " + "p.tel_emergencia, " + "telefono, " + "p.seq_aseguradora, " + "p.seq_lugar_residencia, "
			+ "p.seq_lugar_nacimiento, " + "p.seq_perfil, " + "p.seq_tipo_documento, " + "p.imagen_encriptada, "
			+ "p.lic_salud, " + "p.registro_medico, " + "p.seq_localidad, p.nombre_acompanante, "
			+ "p.telefono_acompanante, p.nombre_persona_responsable, p.telefono_persona_responsable, p.parentesco_persona_responsable, p.tipo_vinculacion, p.municipio_residencia " 
			+ "FROM hc_personas p "
			+ "INNER JOIN hc_rol_usuario_persona as rol ON (rol.seq_persona=p.seq_persona) "
			+ "WHERE rol.tipo_usuario IN (:tipo_usuario);", nativeQuery = true)
	public List<PersonaEntity> findAllTipoUsuario(@Param("tipo_usuario") List<String> seq_tipo_usuario);

	@Query(value = "select * from  hc_personas u"
			+ " left outer join hc_historia_ocupacional p on p.seq_persona = u.seq_persona"
			+ " left outer join hc_historia_gym hg on hg.seq_persona = u.seq_persona"
			+ " where u.numero_documento = ?1", nativeQuery = true)
	public PersonaEntity findByPersonaOcupacional(@Param("documento") String id);

	@Query(value = "select * from  hc_personas u " + " where u.seq_persona = ?1", nativeQuery = true)
	public PersonaEntity findByPersonaMedico(@Param("seq_persona") String id);

	@Query(value = "ALTER TABLE hc_rol_usuario_persona DROP CONSTRAINT tipo_usuario", nativeQuery = true)
	public void eliminarConstRolUsuario();
}
