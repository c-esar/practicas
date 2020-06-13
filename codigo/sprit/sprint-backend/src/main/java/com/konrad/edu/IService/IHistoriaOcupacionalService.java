package com.konrad.edu.IService;

import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IHistoriaOcupacionalService {

	public HistoriaOcupacionalEntity save(HistoriaOcupacionalEntity historia);

	public boolean alterConcepto();

	public boolean alterdiagnostico();
	
	public HistoriaOcupacionalEntity FindBySeqHistoria(Long seqHistoria);
}
