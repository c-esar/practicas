package com.konrad.edu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IPerfilService;
import com.konrad.edu.dao.IPerfilDao;
import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class PerfilServiceImp implements IPerfilService {

	@Autowired
	private IPerfilDao perfildao;

	@Override
	public PerfilEntity getSession(String nom_usuario, String password) {
		return perfildao.findHcPerfilesByNomusuarioAndPassword(nom_usuario, password);
	}

	@Override
	public LabelConstantes getLabels() {
		return new LabelConstantes();
	}

	@Override
	public PerfilEntity save(PerfilEntity persona) {
		return perfildao.save(persona);
	}

	@Override
	public PerfilEntity findHcPerfilesByNumeroDocumneto(String numero_documento) {
		return perfildao.findHcPerfilesByNumeroDocumneto(numero_documento);
	}

	@Override
	public String Encriptar(String textoSinEncriptar) {
		String textoEncriptadoConMD5=DigestUtils.md5Hex(textoSinEncriptar); 
		System.out.println("Texto Encriptado con MD5 : "+textoEncriptadoConMD5);
		return textoEncriptadoConMD5;
	}

}
