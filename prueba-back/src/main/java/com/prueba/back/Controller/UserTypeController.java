package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.back.Model.UserType;
import com.prueba.back.Service.UserTypeService;
import com.prueba.back.utilerias.JSONResponse;

@RestController
@RequestMapping("/userType")
public class UserTypeController {

	@Autowired
	UserTypeService serviceT;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> add(@RequestBody UserType Type) {
		return serviceT.add(Type);
	}

}
