package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.HistoriasEntity;

public interface IHistoriaDao extends CrudRepository<HistoriasEntity, Long> {

}
