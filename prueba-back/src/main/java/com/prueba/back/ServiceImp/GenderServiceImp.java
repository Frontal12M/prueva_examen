package com.prueba.back.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.back.Model.Gender;
import com.prueba.back.Service.GenderService;
import com.prueba.back.repository.GenderRepository;


@Service
public class GenderServiceImp implements GenderService{

	@Autowired
	GenderRepository genderReposity;
	
	@Override
	public Gender findByGenderName(String name) {
		return genderReposity.findByGenderName(name);
	}
	
	@Override
	public List<Gender> findAll() {
		return genderReposity.findAll();
	}
	
}
