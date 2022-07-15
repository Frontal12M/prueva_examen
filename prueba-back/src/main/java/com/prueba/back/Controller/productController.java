package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.back.Model.Producto;
import com.prueba.back.Service.ProductService;
import com.prueba.back.utilerias.JSONResponse;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/Producto")

public class productController {

	@Autowired
	ProductService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> add(@RequestBody Producto producto){
		return service.add(producto);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<JSONResponse> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/get")
	public ResponseEntity<JSONResponse> findById(@RequestParam(name = "id") Integer id) {
		return service.optenerProducto(id);
	}
}
