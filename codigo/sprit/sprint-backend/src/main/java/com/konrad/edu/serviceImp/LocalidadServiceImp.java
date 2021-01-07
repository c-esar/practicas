package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ILocalidadService;
import com.konrad.edu.dao.ILocalidadDao;
import com.konrad.edu.entity.LocalidadEntity;

@Service
public class LocalidadServiceImp implements ILocalidadService {

	@Autowired
	private ILocalidadDao localidadDao;

	@Override
	public List<LocalidadEntity> findAll() {
		return localidadDao.findAll();
	}

}
