package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;

import com.konrad.edu.IService.IAntecedenteHistoriaService;
import com.konrad.edu.dao.IAntecedentesHistoriaDao;

public class AntecedenteHistoriaServiceImp implements IAntecedenteHistoriaService {

	@Autowired
	private IAntecedentesHistoriaDao antecedentesHistoriaDao;
}
