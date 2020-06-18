package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ICertificadoGymService;
import com.konrad.edu.IService.ICertificadoService;
import com.konrad.edu.dao.ICertificadoDao;
import com.konrad.edu.dao.ICertificadoGymDao;
import com.konrad.edu.entity.CertificadoGymEntity;
import com.konrad.edu.entity.CertificadoOcupacionalEntity;

@Service
public class CertificadoGymServiceImp implements ICertificadoGymService {

	@Autowired
	private ICertificadoGymDao certificadoDao;

	@Override
	public CertificadoGymEntity save(CertificadoGymEntity persona) {
		return certificadoDao.save(persona);
	}

	@Override
	public CertificadoGymEntity findByNumeroHistoria(Long seqHistoria) {
		return certificadoDao.findGymByNumeroHistoria(seqHistoria);
	}

}
