package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoEvaluacionService;
import com.konrad.edu.dao.ITipoEvaluacionDao;
import com.konrad.edu.entity.TipoEvaluacionEntity;

@Service
public class TipoEvaluacionServiceImp implements ITipoEvaluacionService {

	@Autowired
	private ITipoEvaluacionDao tipoEvaluacionDao;

	@Override
	public List<TipoEvaluacionEntity> findAll() {
		return (List<TipoEvaluacionEntity>) tipoEvaluacionDao.findAll();
	}

}
