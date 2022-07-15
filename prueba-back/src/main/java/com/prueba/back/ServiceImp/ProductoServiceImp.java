package com.prueba.back.ServiceImp;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.back.Model.Producto;
import com.prueba.back.Service.ProductService;
import com.prueba.back.repository.ProductoRepository;
import com.prueba.back.utilerias.JSONResponse;

@Service
public class ProductoServiceImp implements ProductService {

	private static final Logger LOGGER = LogManager.getLogger(UserInfoServiceImp.class);

	@Autowired
	ProductoRepository repository;

	@Override
	public ResponseEntity<JSONResponse> add(Producto producto) {

		JSONResponse jsonResponse = new JSONResponse();
		try {
			
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(producto));
			jsonResponse.setResponseString("registro exitoso  ");

		} catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("ERROR de producto save  " + e);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}

	@Override
	public ResponseEntity<JSONResponse> findAll() {
		JSONResponse jsonResponse = new JSONResponse();
		try {
			jsonResponse.setResponseObject(repository.findAll());
			jsonResponse.setResponseString("Lista de compañias");
			jsonResponse.setResponseBoolean(true);
		} catch (Exception e) {
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("Error al listar las compañias " + e);
			jsonResponse.setResponseBoolean(false);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(jsonResponse);
	}

	@Override
	public ResponseEntity<JSONResponse> optenerProducto(Integer id) {
		JSONResponse jsonResponse = new JSONResponse();

		Producto hardwareGroup = repository.findById(id).orElse(null);
		if (hardwareGroup == null) {
			return ResponseEntity.notFound().build();
		}
		jsonResponse.setResponseBoolean(true);
		jsonResponse.setResponseString("Producto por id");
		jsonResponse.setResponseObject(hardwareGroup);
		return ResponseEntity.ok(jsonResponse);
	}
}
