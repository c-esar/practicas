package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IEnfermedadesLaboralService;
import com.konrad.edu.dao.IEnfermedadesLaboralDao;
import com.konrad.edu.entity.EnfermedadesLaboralEntity;

@Service
public class EnfermedadesLaboralServiceImp implements IEnfermedadesLaboralService {

	@Autowired
	private IEnfermedadesLaboralDao enfermedadesLaboralDao;

	@Override
	public EnfermedadesLaboralEntity save(EnfermedadesLaboralEntity enfermedadesLaboralEntity) {
		return enfermedadesLaboralDao.save(enfermedadesLaboralEntity);
	}

}
