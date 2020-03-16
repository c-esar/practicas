package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IConceptoService;
import com.konrad.edu.dao.IConceptoDao;
import com.konrad.edu.entity.ConceptoEntity;

@Service
public class ConceptoServiceImp implements IConceptoService {

	@Autowired
	private IConceptoDao conceptoDao;

	@Override
	public List<ConceptoEntity> findAll() {
		return (List<ConceptoEntity>) conceptoDao.findAll();
	}
}
