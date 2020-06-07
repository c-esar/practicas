package com.konrad.edu.IService;

import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;

public interface IPerfilService {

	public PerfilEntity getSession(String nom_usuario, String password);

	public LabelConstantes getLabels();

	public PerfilEntity save(PerfilEntity persona);

	public PerfilEntity findHcPerfilesByNumeroDocumneto(String numero_documento);

	public String Encriptar(String textoSinEncriptar);

	public void delete(PerfilEntity persona);

}
