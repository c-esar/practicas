package com.konrad.edu.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaGymDao extends CrudRepository<HistoriaGYMEntity, Long> {

	@Query(value = "select * from hc_historia_gym u " + "inner join hc_personas p on p.seq_persona = u.seq_persona "
			+ "where p.numero_documento = ?1 ", nativeQuery = true)
	public HistoriaGYMEntity findByPersona(@Param("documento") String id);

	@Query(value = "SELECT * from hc_historia_gym where seq_historia_gym = ?1", nativeQuery = true)
	public HistoriaGYMEntity FindBySeqHistoria(Long seqHistoria);

	@Query(value = "ALTER TABLE hc_condiciones_historia_gym DROP CONSTRAINT seq_condicion_gym", nativeQuery = true)
	public boolean alterCondiciones();

	@Query(value = "ALTER TABLE hc_familiar_historia_gym DROP CONSTRAINT seq_familiar_gym", nativeQuery = true)
	public boolean alterFamiliares();

	@Query(value = "ALTER TABLE hc_rol_usuario_persona DROP CONSTRAINT tipo_usuario", nativeQuery = true)
	public boolean alterUsuarios();

	@Query(value = "ALTER TABLE hc_diagnostico_gym_historia DROP CONSTRAINT seq_diagnostico", nativeQuery = true)
	public boolean alterDiagnostico();
}
