package com.konrad.edu.dao;

import org.springframework.data.repository.CrudRepository;
import com.konrad.edu.entity.TipoDocumentoEntity;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumentoEntity, Long> {

}
