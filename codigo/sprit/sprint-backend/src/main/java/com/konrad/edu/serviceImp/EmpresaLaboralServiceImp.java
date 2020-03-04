package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IEmpresaLaboralService;
import com.konrad.edu.dao.IEmpresaLaboralDao;
import com.konrad.edu.entity.EmpresaLaboralEntity;

@Service
public class EmpresaLaboralServiceImp implements IEmpresaLaboralService {

	@Autowired
	private IEmpresaLaboralDao empresaLaboralDao;

	@Override
	public EmpresaLaboralEntity save(EmpresaLaboralEntity empresaLaboralEntity) {
		return empresaLaboralDao.save(empresaLaboralEntity);
	}

}
