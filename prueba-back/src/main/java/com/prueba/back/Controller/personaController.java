package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Persona;
import com.prueba.back.Service.PersonaService;

@RestController
@RequestMapping("/personas")
public class personaController {
	
	@Autowired
	PersonaService service;

	@PostMapping("/save")
	public ResponseEntity<JSONResponse>save (@RequestBody Persona persona){
		return service.save(persona);
	}
}
