package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.CertificadoOcupacionalEntity;

public interface ICertificadoDao extends CrudRepository<CertificadoOcupacionalEntity, Long> {

	@Query(value = "select * from hc_certificado_ocupacional hc" 
			+" inner join hc_historia_ocupacional as hho on hho.seq_historia = hc.seq_historia"
			+" where hho.seq_historia =  ?1", nativeQuery = true)
	public CertificadoOcupacionalEntity findByNumeroHistoria(@Param("seq_historia") Long seqHistoria);

	@Query(value = "select hho.persona_medico from hc_certificado_ocupacional hc "
			+ "inner join hc_historia_ocupacional hho on hho.seq_historia = hc.seq_historia "
			+ "where hc.seq_certificado = ?1", nativeQuery = true)
	public String findByNumeroCertificado(@Param("seq_certificado") String seqHistoria);
}
