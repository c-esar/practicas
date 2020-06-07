package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.CertificadoOcupacionalEntity;

public interface ICertificadoDao extends CrudRepository<CertificadoOcupacionalEntity, Long> {

	@Query(value = "select * from hc_certificado hc "
			+ "inner join hc_certificado_ocupacional as hco on hco.seq_certificado = hc.seq_certificado "
			+ "inner join hc_historia_ocupacional as hho on hho.seq_historia = hco.seq_historia "
			+ "where hco.seq_historia = ?1", nativeQuery = true)
	public CertificadoOcupacionalEntity findByNumeroHistoria(@Param("seq_historia") Long seqHistoria);

	@Query(value = "select hho.persona_medico from hc_certificado hc "
			+ "inner join hc_certificado_ocupacional hco on hco.seq_certificado = hc.seq_certificado "
			+ "inner join hc_historia_ocupacional hho on hho.seq_historia = hco.seq_historia "
			+ "where hc.seq_certificado = ?1", nativeQuery = true)
	public String findByNumeroCertificado(@Param("seq_certificado") String seqHistoria);
}
