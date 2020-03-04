package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IFactoresRiesgoService;
import com.konrad.edu.dao.IFactoresRiesgoDao;
import com.konrad.edu.entity.FactoresRiesgoEntity;

@Service
public class FactoresRiesgoServiceImp implements IFactoresRiesgoService {

	@Autowired
	private IFactoresRiesgoDao factoresRiesgoDao;

	@Override
	public FactoresRiesgoEntity save(FactoresRiesgoEntity factoresRiesgoEntity) {
		return factoresRiesgoDao.save(factoresRiesgoEntity);
	}

}
