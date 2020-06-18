package com.konrad.edu.IService;

import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaGymService {

	public HistoriaGYMEntity save(HistoriaGYMEntity historia);
	
	public HistoriaGYMEntity FindBySeqHistoria(Long seqHistoria);

	public boolean alterCondiciones();

	public boolean alterFamiliares();

	public boolean alterUsuarios();

	public boolean alterDiagnostico();
}
