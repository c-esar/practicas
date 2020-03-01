package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IPersonaService;
import com.konrad.edu.dao.IPersonaDao;
import com.konrad.edu.entity.PersonaEntity;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<PersonaEntity> findAll() {
		return (List<PersonaEntity>) personaDao.findAll();
	}

	@Override
	public PersonaEntity findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	public PersonaEntity save(PersonaEntity persona) {
		return personaDao.save(persona);
	}

	@Override
	public void delete(Long id) {
		personaDao.deleteById(id);
	}

	@Override
	public PersonaEntity findByNumeroDocumento(String numero_documento) {
		return personaDao.findByNumeroDocumento(numero_documento);
	}

}