package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoUsuarioService;
import com.konrad.edu.dao.ITipoUsuarioDao;
import com.konrad.edu.entity.TipoUsuarioEntity;

@Service
public class TipoUsuarioServiceImp implements ITipoUsuarioService {

	@Autowired
	private ITipoUsuarioDao tipoDao;

	@Override
	public List<TipoUsuarioEntity> findAll() {
		return (List<TipoUsuarioEntity>) tipoDao.findAll();
	}

}
