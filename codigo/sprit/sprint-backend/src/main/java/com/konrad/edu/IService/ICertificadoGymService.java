package com.konrad.edu.IService;

import com.konrad.edu.entity.CertificadoGymEntity;
import com.konrad.edu.entity.CertificadoOcupacionalEntity;

public interface ICertificadoGymService {

	public CertificadoGymEntity save(CertificadoGymEntity certificado);

	public CertificadoGymEntity findByNumeroHistoria(Long seqHistoria);
}
