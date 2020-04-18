package com.konrad.edu.IService;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;
import com.konrad.edu.entity.PersonaEntity;

public interface IPerfilService {

	public PerfilEntity getSession(String nom_usuario, String password);

	public LabelConstantes getLabels();
	
	public PerfilEntity save(PerfilEntity persona);

	public PerfilEntity findHcPerfilesByNumeroDocumneto(String numero_documento);
	
}
