package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.prueba.back.Model.UserInfo;
import com.prueba.back.utilerias.JSONResponse;

public interface UserInfoService {

	public ResponseEntity<JSONResponse> add (UserInfo info);
}
