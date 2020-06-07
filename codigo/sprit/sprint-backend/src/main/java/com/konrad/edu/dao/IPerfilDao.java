package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PerfilEntity;

public interface IPerfilDao extends CrudRepository<PerfilEntity, Long> {

	@Query(value = "select * from hc_perfiles u" + " inner join hc_personas hp on hp.seq_perfil = u.seq_perfil"
			+ " where u.nom_usuario = ?1 and u.password = ?2 and u.estado = 'A'", nativeQuery = true)
	public PerfilEntity findHcPerfilesByNomusuarioAndPassword(@Param("nom_usuario") String nom_usuario,
			@Param("password") String password);

	@Query(value = "select  * from hc_perfiles f "
			+ "right outer join dbo.hc_personas p on p.seq_perfil = f.seq_perfil "
			+ "where p.numero_documento = ?1", nativeQuery = true)
	public PerfilEntity findHcPerfilesByNumeroDocumneto(@Param("numero_documento") String numero_documento);

}
