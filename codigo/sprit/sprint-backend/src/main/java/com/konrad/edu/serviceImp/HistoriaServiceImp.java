package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaService;
import com.konrad.edu.dao.IHistoriaDao;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

@Service
public class HistoriaServiceImp implements IHistoriaService {

	@Autowired
	private IHistoriaDao historiaDao;

	@Override
	public HistoriaOcupacionalEntity save(HistoriaOcupacionalEntity historia) {
		return historiaDao.save(historia);
	}
}
