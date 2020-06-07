package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ICertificadoService;
import com.konrad.edu.dao.ICertificadoDao;
import com.konrad.edu.entity.CertificadoOcupacionalEntity;

@Service
public class CertificadoServiceImp implements ICertificadoService {

	@Autowired
	private ICertificadoDao certificadoDao;

	@Override
	public CertificadoOcupacionalEntity save(CertificadoOcupacionalEntity persona) {
		return certificadoDao.save(persona);
	}

	@Override
	public CertificadoOcupacionalEntity findByNumeroHistoria(Long seqHistoria) {
		return certificadoDao.findByNumeroHistoria(seqHistoria);
	}

}
