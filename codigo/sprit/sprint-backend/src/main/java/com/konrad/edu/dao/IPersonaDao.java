package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;

import com.konrad.edu.entity.Persona;


public interface IPersonaDao extends CrudRepository<Persona,Long>{

}
