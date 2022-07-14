package com.prueba.back.ServiceImp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.priv.iotcontroldevices.utilerias.JSONResponse;
import com.prueba.back.Model.prueba1;
import com.prueba.back.Service.prueba1Service;
import com.prueba.back.repository.prueba1Repository;

@Service
public class prueba1ServiceImp implements prueba1Service{
	
	@Autowired
	prueba1Repository repository;

	private static final Logger LOGGER = LogManager.getLogger(prueba1ServiceImp.class);

	@Override
	public ResponseEntity<JSONResponse> save(String json) {
		JSONResponse jsonResponse = new JSONResponse();
		prueba1 activity = new prueba1();
		try {

			JSONObject jsonObject = new JSONObject(json);

			activity.setMessage(jsonObject.getString("message"));
			activity.setType(jsonObject.getString("Messagetype"));
			activity.setSeverity(jsonObject.getString("severity"));
			activity.setTopic(jsonObject.getString("topic"));


			jsonResponse.setResponseString("actividad agregada");
			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(activity));


		} catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseString("Error ActivityLogServiceImp save  " + e);
			jsonResponse.setResponseObject(null);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);

	}

}
