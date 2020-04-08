package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.IFamiliarGymService;
import com.konrad.edu.dao.IFamiliarGymDao;
import com.konrad.edu.entity.FamiliarGymEntity;

@Service
public class FamiliarGymServiceImp implements IFamiliarGymService {

	@Autowired
	private IFamiliarGymDao familiarDao;

	@Override
	public List<FamiliarGymEntity> findAll() {
		return (List<FamiliarGymEntity>) familiarDao.findAll();
	}
	
	
}
