package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ICiudadService;
import com.konrad.edu.dao.ICiudadDao;
import com.konrad.edu.entity.CiudadEntity;

@Service
public class CuidadServiceImp implements ICiudadService {

	@Autowired
	private ICiudadDao ciudadDao;

	@Override
	public List<CiudadEntity> findAll() {
		return ciudadDao.findAll();
	}

}
