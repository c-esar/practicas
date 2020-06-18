package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.CertificadoGymEntity;
import com.konrad.edu.entity.CertificadoOcupacionalEntity;

public interface ICertificadoGymDao extends CrudRepository<CertificadoGymEntity, Long> {
	
	@Query(value = "select * from hc_certificado_gym hc" 
			+" inner join hc_historia_gym as hho on hho.seq_historia_gym = hc.seq_historia"
			+" where hho.seq_historia_gym =  ?1", nativeQuery = true)
	public CertificadoGymEntity findGymByNumeroHistoria(@Param("seq_historia") Long seqHistoria);
	
	@Query(value = "select hho.persona_medico from hc_certificado_gym hc "
			+ "inner join hc_historia_gym hho on hho.seq_historia_gym = hc.seq_historia "
			+ "where hc.seq_certificado =  ?1", nativeQuery = true)
	public String findGymByNumeroCertificado(@Param("seq_certificado") String seqHistoria);
}
