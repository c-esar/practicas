package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoPreguntaHistoriaService;
import com.konrad.edu.dao.ITipoPreguntaHistoriaGymDao;
import com.konrad.edu.entity.TipoPreguntaHistoriaGymEntity;

@Service
public class TipoPreguntaHistoriaGymServiceImp implements ITipoPreguntaHistoriaService {

	@Autowired
	private ITipoPreguntaHistoriaGymDao tipoPregunta;

	@Override
	public List<TipoPreguntaHistoriaGymEntity> findAll() {
		return (List<TipoPreguntaHistoriaGymEntity>) tipoPregunta.findAll();
	}

}
