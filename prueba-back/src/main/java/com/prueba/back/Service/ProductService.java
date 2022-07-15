package com.prueba.back.Service;

import org.springframework.http.ResponseEntity;

import com.prueba.back.Model.Producto;
import com.prueba.back.utilerias.JSONResponse;

public interface ProductService {
	public ResponseEntity<JSONResponse> add(Producto producto);

	public ResponseEntity<JSONResponse> findAll();
	
	public ResponseEntity<JSONResponse>optenerProducto(Integer id);
}
