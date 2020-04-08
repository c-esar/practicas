package com.konrad.edu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konrad.edu.IService.ICondicionGymService;
import com.konrad.edu.dao.ICondicionGymDao;
import com.konrad.edu.entity.CondicionGymEntity;

@Service
public class CondicionGymServiceImp implements ICondicionGymService {

	@Autowired
	private ICondicionGymDao condicionDao;

	@Override
	public List<CondicionGymEntity> findAll() {
		return (List<CondicionGymEntity>) condicionDao.findAll();
	}
}
