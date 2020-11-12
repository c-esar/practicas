package com.konrad.edu.IService;

import java.util.List;

import com.konrad.edu.entity.AntecedentesHistoriaEntity;
import com.konrad.edu.entity.AntecedentesHistoriaEntityEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;
import com.konrad.edu.entity.ParaclinicosEntity;
import com.konrad.edu.entity.ParaclinicosEntityEncriptacion;

public interface IEncriptacionDatosService {

	public HistoriaOcupacionalEntity encriptacionHistoriaOcupacional(HistoriaOcupacionalEncriptacion historiaEntity);

	public HistoriaGYMEntity encriptacionHistoriaGym(HistoriaGymEncriptacion historiaEntity);

	public ExamenFisicoEntity encriptacionExamenFisico(ExamenFisicoEncriptacion examenFisicoEntity);
	
	public List<ParaclinicosEntity> encriptacionParaclinicosEntity(List<ParaclinicosEntityEncriptacion> encriptacionParaclinicosEntity);
	
	public List<AntecedentesHistoriaEntity> encriptacionAntecedentesHistoriaEntity( List<AntecedentesHistoriaEntityEncriptacion> encriptacionantecedentesEntity);
}
