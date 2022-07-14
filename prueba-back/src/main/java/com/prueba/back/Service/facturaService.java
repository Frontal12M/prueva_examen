package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Factura;

public interface facturaService {

	public ResponseEntity<JSONResponse>save(Factura factura );
	
	public ResponseEntity<JSONResponse>update(Factura factura);
	
}
