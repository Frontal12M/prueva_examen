package com.prueba.back.Service;

import java.util.List;

import com.prueba.back.Model.Gender;


public interface GenderService {
	public Gender findByGenderName(String name);
	public List<Gender>findAll();
}
