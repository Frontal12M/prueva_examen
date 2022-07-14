package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Service.prueba1Service;

@RestController 
@RequestMapping("/pruebas")
public class prueba1Controller {
	
	@Autowired
	prueba1Service service;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> save(@RequestBody String json) {

		return service.save(json);
	}
	
	
	

}
