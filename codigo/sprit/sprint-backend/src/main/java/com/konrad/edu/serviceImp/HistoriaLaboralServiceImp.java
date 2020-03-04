package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaLaboralService;
import com.konrad.edu.dao.IHistoriaLaboralDao;
import com.konrad.edu.entity.HistoriaLaboralEntity;

@Service
public class HistoriaLaboralServiceImp implements IHistoriaLaboralService {

	@Autowired
	private IHistoriaLaboralDao historiaLaboralDao;

	@Override
	public HistoriaLaboralEntity save(HistoriaLaboralEntity historiaLaboralEntity) {
		return historiaLaboralDao.save(historiaLaboralEntity);
	}
}
