package com.konrad.edu.IService;

import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public interface IEncriptacionDatosService {

	public HistoriaOcupacionalEntity encriptacionHistoriaOcupacional(HistoriaOcupacionalEncriptacion historiaEntity);
	
	public HistoriaGYMEntity encriptacionHistoriaGym(HistoriaGymEncriptacion historiaEntity);
	
	public ExamenFisicoEntity encriptacionExamenFisico(ExamenFisicoEncriptacion examenFisicoEntity);
}
