package com.konrad.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.dao.IPerfilDao;
import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.Perfil;

@Service
public class PerfilServiceImp implements IPerfilService{

	@Autowired
	private IPerfilDao perfildao;
	@Override
	public Perfil getSession(String nom_usuario, String password) {
		return perfildao.findHcPerfilesByNomusuarioAndPassword(nom_usuario, password);
	}
	@Override
	public LabelConstantes getLabels() {
		return new LabelConstantes();
	}

}
