package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoAntecedenteService;
import com.konrad.edu.dao.ITipoAntecedenteDao;
import com.konrad.edu.entity.TipoAntecedenteEntity;

@Service
public class TipoAntecedenteServiceImp implements ITipoAntecedenteService{

	@Autowired
	private ITipoAntecedenteDao tipoAntecedenteDao;
	
	@Override
	public List<TipoAntecedenteEntity> findAll() {
		return (List<TipoAntecedenteEntity>) tipoAntecedenteDao.findAll();
	}


}
