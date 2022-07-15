package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.prueba.back.Model.UserType;
import com.prueba.back.utilerias.JSONResponse;

public interface UserTypeService {

	public ResponseEntity<JSONResponse>add(UserType userType);
}
