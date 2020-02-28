package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IHistoriaService;
import com.konrad.edu.dao.IHistoriaDao;

@Service
public class HistoriaServiceImp implements IHistoriaService {

	@Autowired
	private IHistoriaDao historiaDao;
}
