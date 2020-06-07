package com.konrad.edu.IService;

import com.konrad.edu.entity.CertificadoOcupacionalEntity;

public interface ICertificadoService {

	public CertificadoOcupacionalEntity save(CertificadoOcupacionalEntity certificado);

	public CertificadoOcupacionalEntity findByNumeroHistoria(Long seqHistoria);
}
