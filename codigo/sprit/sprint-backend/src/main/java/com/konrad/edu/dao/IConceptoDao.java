package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.ConceptoEntity;

public interface IConceptoDao extends CrudRepository<ConceptoEntity, Long> {

}
