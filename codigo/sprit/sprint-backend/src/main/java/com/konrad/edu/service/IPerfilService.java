package com.konrad.edu.service;

import java.util.List;

import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.Perfil;

public interface IPerfilService {

	public Perfil getSession(String nom_usuario, String password);
	
	public LabelConstantes getLabels();

}
