package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IAntecedentesTrabajoService;
import com.konrad.edu.dao.IAntecedentesTrabajoDao;
import com.konrad.edu.entity.AntecedentesTrabajoEntity;

@Service
public class AntecedentesTrabajoServiceImp implements IAntecedentesTrabajoService {

	@Autowired
	private IAntecedentesTrabajoDao antecedentesTrabajoDao;

	@Override
	public AntecedentesTrabajoEntity save(AntecedentesTrabajoEntity antecedentesTrabajoEntity) {
		return antecedentesTrabajoDao.save(antecedentesTrabajoEntity);
	}

}
