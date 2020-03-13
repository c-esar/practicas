package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.PerfilEntity;

public interface IPerfilDao extends CrudRepository<PerfilEntity, Long> {

	@Query(value = "select * from HC_Historias.dbo.hc_perfiles u where u.nom_usuario = ?1 and u.password = ?2", nativeQuery = true)
	public PerfilEntity findHcPerfilesByNomusuarioAndPassword(@Param("nom_usuario") String nom_usuario,
			@Param("password") String password);

}
