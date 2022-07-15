package com.prueba.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.back.Model.Gender;


public interface GenderRepository extends JpaRepository<Gender, Integer>{
	@Query(value="SELECT g FROM Gender g WHERE g.gender=:gender")
	public Gender findByGenderName(@Param("gender") String genderName);
}
