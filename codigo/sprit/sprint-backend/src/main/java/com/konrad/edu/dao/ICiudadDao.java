package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konrad.edu.entity.CiudadEntity;

public interface ICiudadDao extends JpaRepository<CiudadEntity, Long> {

}
