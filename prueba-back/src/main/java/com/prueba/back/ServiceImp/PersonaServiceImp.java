package com.prueba.back.ServiceImp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Persona;
import com.prueba.back.Service.PersonaService;
import com.prueba.back.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService {
	
	@Autowired
	PersonaRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(PersonaServiceImp.class);

	@Override
	public ResponseEntity<JSONResponse> save(Persona persona) {
		
		JSONResponse jsonResponse = new JSONResponse();
		
		try {
			
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(persona));
			jsonResponse.setResponseString("El registro se ha creado");
			
			
		}catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("Error FacturaServiceImp " + e.getMessage());
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}

}
