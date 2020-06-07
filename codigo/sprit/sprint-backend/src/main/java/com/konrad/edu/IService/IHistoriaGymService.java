package com.konrad.edu.IService;

import com.konrad.edu.entity.HistoriaGYMEntity;

public interface IHistoriaGymService {

	public HistoriaGYMEntity save(HistoriaGYMEntity historia);

	public boolean alterCondiciones();

	public boolean alterFamiliares();

	public boolean alterUsuarios();

	public boolean alterDiagnostico();
}
