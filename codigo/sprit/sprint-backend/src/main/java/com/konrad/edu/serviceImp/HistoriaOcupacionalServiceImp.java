package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaOcupacionalService;
import com.konrad.edu.dao.IHistoriaOcupacionalDao;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

@Service
public class HistoriaOcupacionalServiceImp implements IHistoriaOcupacionalService {

	@Autowired
	private IHistoriaOcupacionalDao historiaDao;

	@Override
	public HistoriaOcupacionalEntity save(HistoriaOcupacionalEntity historia) {
		return historiaDao.save(historia);
	}

	@Override
	public boolean alterConcepto() {
		return historiaDao.alterConcepto();
		
	}

	@Override
	public boolean alterdiagnostico() {
		return historiaDao.alterdiagnostico();
	}
}
