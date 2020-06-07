package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IDiagnosticaOcupacionalService;
import com.konrad.edu.dao.IDiagnosticaOcupacionalDao;
import com.konrad.edu.entity.DiagnosticoEntity;

@Service
public class DiagnosticoOcupacionalServiceImp implements IDiagnosticaOcupacionalService {

	@Autowired
	private IDiagnosticaOcupacionalDao iDiagnosticoOcupacionalDao;

	@Override
	public List<DiagnosticoEntity> findAll() {
		return (List<DiagnosticoEntity>) iDiagnosticoOcupacionalDao.findAll();
	}

}
