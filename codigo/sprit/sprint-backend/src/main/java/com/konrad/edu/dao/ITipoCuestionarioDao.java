package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.TipoCuestionarioEntity;

public interface ITipoCuestionarioDao extends CrudRepository<TipoCuestionarioEntity, Long> {

}
