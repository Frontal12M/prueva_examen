package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.back.Model.UserInfo;
import com.prueba.back.Service.UserInfoService;
import com.prueba.back.utilerias.JSONResponse;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	UserInfoService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> add(@RequestBody UserInfo info) {
		return service.add(info);
	}
}
