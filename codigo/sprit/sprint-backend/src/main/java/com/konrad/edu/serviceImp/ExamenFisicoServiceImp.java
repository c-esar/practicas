package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;

import com.konrad.edu.IService.IExamenFisicoService;
import com.konrad.edu.dao.IExamenFisicoDao;

public class ExamenFisicoServiceImp implements IExamenFisicoService {

	@Autowired
	private IExamenFisicoDao examenFisicoDao;

}
