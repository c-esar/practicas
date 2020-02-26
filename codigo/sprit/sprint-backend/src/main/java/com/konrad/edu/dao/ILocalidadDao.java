package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konrad.edu.entity.LocalidadEntity;

public interface ILocalidadDao extends JpaRepository<LocalidadEntity, Long> {

}
