package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.prueba.back.Model.User;
import com.prueba.back.utilerias.JSONResponse;

public interface UserService {

	public ResponseEntity<JSONResponse> add(User user);

	public ResponseEntity<JSONResponse> addUserByClientManager(User userAccount);

	public ResponseEntity<JSONResponse> login(String email, String password);

}
