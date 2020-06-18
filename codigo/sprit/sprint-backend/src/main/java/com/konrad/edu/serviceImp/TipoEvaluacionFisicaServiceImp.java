package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoEvaluacionFisicaService;
import com.konrad.edu.IService.ITipoEvaluacionService;
import com.konrad.edu.dao.ITipoEvaluacionDao;
import com.konrad.edu.dao.ITipoEvaluacionFisicaDao;
import com.konrad.edu.entity.TipoEvaluacionEntity;
import com.konrad.edu.entity.TipoEvaluacionFisicaEntity;

@Service
public class TipoEvaluacionFisicaServiceImp implements ITipoEvaluacionFisicaService {

	@Autowired
	private ITipoEvaluacionFisicaDao tipoEvaluacionDao;

	@Override
	public List<TipoEvaluacionFisicaEntity> findAll() {
		return (List<TipoEvaluacionFisicaEntity>) tipoEvaluacionDao.findAll();
	}

}
