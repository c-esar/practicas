package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.TipoEvaluacionEntity;
import com.konrad.edu.entity.TipoEvaluacionFisicaEntity;

public interface ITipoEvaluacionFisicaDao extends CrudRepository<TipoEvaluacionFisicaEntity, Long> {

}
