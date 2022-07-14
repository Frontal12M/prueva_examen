package com.prueba.back.ServiceImp;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.Factura;
import com.prueba.back.Service.facturaService;
import com.prueba.back.repository.facturaRepository;

@Service
public class FacturaServiceImp implements facturaService {

	@Autowired
	facturaRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(FacturaServiceImp.class);

	
	@Override
	public ResponseEntity<JSONResponse> save(Factura factura) {
		JSONResponse jsonResponse = new JSONResponse();
		
		try {
			
			factura.setCreatedDate(new Date());
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(factura));
			jsonResponse.setResponseString("Factura Creada Con Exito");
			
		}catch (Exception e ){
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("Error FacturaServiceImp " + e.getMessage());
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}


	@Override
	public ResponseEntity<JSONResponse> update(Factura factura) {
		JSONResponse jsonResponse = new JSONResponse();
		try {
			Factura fac = repository.findById(factura.getIdFactura()).orElse(null);
			
			
			if(fac == null) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseObject(null);
				jsonResponse.setResponseString("La Factura no se encuentra registrada");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			
			}
			factura.setCreatedDate(new Date());
			fac.setMonto(factura.getMonto());
			//fac.setCreatedDate(factura.getCreatedDate());
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(repository.save(factura));
			jsonResponse.setResponseString("El Monto se ha actulizado");
			
			
			
			
		}catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString(" Error FacturaServiceImp update " + e);
			LOGGER.error(jsonResponse.getResponseString());
		}
		return ResponseEntity.ok(jsonResponse);
	}
		
	

}
