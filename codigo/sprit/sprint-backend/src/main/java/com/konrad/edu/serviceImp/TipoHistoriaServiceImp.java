package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoHistoriaService;
import com.konrad.edu.dao.ITipoHistoriaDao;
import com.konrad.edu.entity.TipoHistoriasEntity;

@Service
public class TipoHistoriaServiceImp implements ITipoHistoriaService {

	@Autowired
	private ITipoHistoriaDao tipoHistoriaDao;

	@Override
	public List<TipoHistoriasEntity> findAll() {
		return (List<TipoHistoriasEntity>) tipoHistoriaDao.findAll();
	}

}
