package com.konrad.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.konrad.edu.entity.Perfil;


public interface IPerfilDao extends JpaRepository<Perfil,Long>{

	@Query(value="select * from HC_Historias.dbo.hc_perfiles u where u.nom_usuario = ?1 and u.password = ?2", nativeQuery = true)
	public Perfil findHcPerfilesByNomusuarioAndPassword(@Param("nom_usuario")String nom_usuario, @Param("password")String password);

}
