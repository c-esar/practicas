package com.konrad.edu.IService;

import com.konrad.edu.entity.CertificadoEntity;

public interface ICertificadoService {

	public CertificadoEntity save(CertificadoEntity certificado);

	public CertificadoEntity findByNumeroHistoria(Long seqHistoria);
}
