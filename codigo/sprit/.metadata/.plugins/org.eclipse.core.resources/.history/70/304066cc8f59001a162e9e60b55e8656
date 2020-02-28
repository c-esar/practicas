package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ITipoDocumentoService;
import com.konrad.edu.dao.ITipoDocumentoDao;
import com.konrad.edu.entity.TipoDocumentoEntity;

@Service
public class TipoDocumentoServiceImp implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoDao tipoDao;
	
	@Override
	public List<TipoDocumentoEntity> findAll() {
		return  (List<TipoDocumentoEntity>) tipoDao.findAll();
	}

}
