package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Factura;
import com.prueba.back.Service.facturaService;

@RestController
@RequestMapping("/facturas")
public class facturaController {
	
	@Autowired
	private facturaService facturaService;
	
	@PostMapping("/save")
	public ResponseEntity<JSONResponse>save(@RequestBody Factura factura){
		return facturaService.save(factura);
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<JSONResponse>update(@PathVariable("id") Integer id, @RequestBody Factura factura){
		factura.setIdFactura(id);
		return facturaService.update(factura);
	}
	
	
	
	

}
