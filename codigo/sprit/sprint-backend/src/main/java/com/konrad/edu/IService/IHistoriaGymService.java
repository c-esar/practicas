package com.konrad.edu.IService;

import org.springframework.data.jpa.repository.Query;

import com.konrad.edu.entity.HistoriaGYMEntity;

public interface IHistoriaGymService {

	public HistoriaGYMEntity save(HistoriaGYMEntity historia);
	
	public boolean alterCondiciones();
	
	public boolean alterFamiliares();
	
	public boolean alterUsuarios();
}
