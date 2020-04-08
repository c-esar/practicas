package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoCuestioService;
import com.konrad.edu.dao.ITipoCuestionarioDao;
import com.konrad.edu.entity.TipoCuestionarioEntity;

@Service
public class TipoCuestionarioServiceImp implements ITipoCuestioService{

	@Autowired
	private ITipoCuestionarioDao tipoCuestionario;
	
	@Override
	public List<TipoCuestionarioEntity> findAll() {
		return (List<TipoCuestionarioEntity>) tipoCuestionario.findAll();
	}
	
}
