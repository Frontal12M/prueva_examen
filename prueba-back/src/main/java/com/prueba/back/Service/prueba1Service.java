package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.priv.iotcontroldevices.utilerias.JSONResponse;

public interface prueba1Service {

	public ResponseEntity<JSONResponse> save(String json);
}
