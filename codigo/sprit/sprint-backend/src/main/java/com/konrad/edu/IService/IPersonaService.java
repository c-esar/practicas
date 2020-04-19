package com.konrad.edu.IService;

import java.util.Collection;
import java.util.List;

import com.konrad.edu.entity.PersonaEntity;

public interface IPersonaService {

	public List<PersonaEntity> findAll();

	public PersonaEntity findById(Long id);

	public PersonaEntity save(PersonaEntity persona);

	public void delete(Long id);

	public PersonaEntity findByNumeroDocumento(String numero_documento);
	
	public PersonaEntity findByNumeroPerfil(String seq_perfil);
	
	public List<PersonaEntity> findAllTipoUsuario(List<String> seq_tipo_usuario);

}
