package com.prueba.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.back.Model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
