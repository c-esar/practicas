package com.konrad.edu.IService;

import java.util.List;

import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;

public interface IPerfilService {

	public PerfilEntity getSession(String nom_usuario, String password);

	public LabelConstantes getLabels();

}