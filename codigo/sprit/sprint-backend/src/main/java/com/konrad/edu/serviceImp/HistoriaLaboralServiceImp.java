package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaLaboralService;
import com.konrad.edu.dao.IHistoriaLaboralDao;

@Service
public class HistoriaLaboralServiceImp implements IHistoriaLaboralService {

	@Autowired
	private IHistoriaLaboralDao historiaLaboralDao;
}
