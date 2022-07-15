package com.prueba.back.ServiceImp;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.back.Model.UserInfo;
import com.prueba.back.Service.UserInfoService;
import com.prueba.back.repository.GenderRepository;
import com.prueba.back.repository.UserInfoRepository;
import com.prueba.back.utilerias.JSONResponse;

@Service
public class UserInfoServiceImp implements UserInfoService {

	@Autowired
	UserInfoRepository repository;
	
	@Autowired
	GenderRepository repogender;
	
	private static final Logger LOGGER = LogManager.getLogger(UserInfoServiceImp.class);

	
	@Override
	public ResponseEntity<JSONResponse> add(UserInfo info) {
		JSONResponse jsonResponse = new JSONResponse();
		try {
		
			
			
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(info));
			jsonResponse.setResponseString("La informacion fue registrada");
			
		}catch(Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("ERROR de UserInfo save  " + e);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}
}
