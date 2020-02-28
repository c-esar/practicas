package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IAseguradoraService;
import com.konrad.edu.dao.IAseguradoraDao;
import com.konrad.edu.entity.AseguradoraEntity;

@Service
public class AseguradoraServiceImp implements IAseguradoraService {

	@Autowired
	private IAseguradoraDao aseguradoraDao;

	@Override
	public List<AseguradoraEntity> findAll() {
		return aseguradoraDao.findAll();
	}

}
