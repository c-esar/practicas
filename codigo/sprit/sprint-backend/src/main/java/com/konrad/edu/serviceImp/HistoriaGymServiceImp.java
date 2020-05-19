package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaGymService;
import com.konrad.edu.dao.IHistoriaGymDao;
import com.konrad.edu.entity.HistoriaGYMEntity;

@Service
public class HistoriaGymServiceImp implements IHistoriaGymService{

	@Autowired
	private IHistoriaGymDao historiaDao;

	@Override
	public HistoriaGYMEntity save(HistoriaGYMEntity historia) {
		return historiaDao.save(historia);
	}

	@Override
	public boolean alterCondiciones() {
		return historiaDao.alterCondiciones();
	}

	@Override
	public boolean alterFamiliares() {
		return historiaDao.alterFamiliares();
	}

	@Override
	public boolean alterUsuarios() {
		return historiaDao.alterUsuarios();
	}
}
