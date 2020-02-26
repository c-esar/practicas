package com.konrad.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.konrad.edu.entity.TipoDocumentoEntity;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumentoEntity, Long> {
}
