package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Persona;

public interface PersonaService {
	
	public ResponseEntity<JSONResponse>save(Persona persona);
	
}
