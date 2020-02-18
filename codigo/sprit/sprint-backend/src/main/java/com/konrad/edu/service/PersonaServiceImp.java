package com.konrad.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.dao.IPersonaDao;
import com.konrad.edu.entity.Persona;

@Service
public class PersonaServiceImp implements IPersonaService{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

}
