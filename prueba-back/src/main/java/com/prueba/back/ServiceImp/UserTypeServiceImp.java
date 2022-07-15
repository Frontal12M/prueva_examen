package com.prueba.back.ServiceImp;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.back.Model.UserType;
import com.prueba.back.Service.UserTypeService;
import com.prueba.back.repository.UserTypeRepository;
import com.prueba.back.utilerias.JSONResponse;

@Service
public class UserTypeServiceImp implements UserTypeService {

	@Autowired
	UserTypeRepository repository;

	
	private static final Logger LOGGER = LogManager.getLogger(UserTypeServiceImp.class);

	@Override
	public ResponseEntity<JSONResponse> add(UserType userType) {
		JSONResponse jsonResponse = new JSONResponse();

		try {
			
			Optional<UserType> opc = repository.findByName(userType.getType());
			
			if(opc.isPresent()) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseObject(null);
				jsonResponse.setResponseString("esta asigancio ya se encuentra registrada");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(userType));
			jsonResponse.setResponseString("registro exitoso  ");
		}catch(Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("ERROR de UserType save  " + e);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}

}
