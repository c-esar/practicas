package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaOcupacionalDao extends CrudRepository<HistoriaOcupacionalEntity, Long> {

}
