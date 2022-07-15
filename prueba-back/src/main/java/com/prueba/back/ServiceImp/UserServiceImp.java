package com.prueba.back.ServiceImp;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.back.Model.User;
import com.prueba.back.Model.UserInfo;
import com.prueba.back.Model.UserType;
import com.prueba.back.Service.UserService;
import com.prueba.back.repository.GenderRepository;
import com.prueba.back.repository.UserInfoRepository;
import com.prueba.back.repository.UserRepository;
import com.prueba.back.repository.UserTypeRepository;
import com.prueba.back.utilerias.JSONResponse;

@Service
public class UserServiceImp implements UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImp.class);

	@Autowired
	UserRepository repository;

	@Autowired
	UserInfoRepository repositoryInf;

	@Autowired
	UserTypeRepository repositoryTeype;
	@Autowired
	GenderRepository genderReposity;

	@Override
	public ResponseEntity<JSONResponse> add(User user) {
		JSONResponse jsonResponse = new JSONResponse();
		try {

			Optional<UserInfo> opcinfo = repositoryInf.findById(user.getFkUserInfo().getIdUserInfo());
			if (!opcinfo.isPresent()) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseObject(null);
				jsonResponse.setResponseString(" El informacion del usuario   no esta registrado ");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}

			Optional<UserType> opcType = repositoryTeype.findById(user.getFkUserType().getIdUserType());
			if (!opcType.isPresent()) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseObject(null);
				jsonResponse.setResponseString(" EL tipo de usuario no esta registrado ");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);

			}

			user.setFkUserInfo(opcinfo.get());
			user.setFkUserType(opcType.get());
			user.setToken("ANYTOKEN");

			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseObject(repository.save(user));
			jsonResponse.setResponseString("El usaurio se ha registrado");
		} catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseObject(null);
			jsonResponse.setResponseString("Error de add de user" + e);

			LOGGER.error("add " + e);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);

	}

	@Override
	public ResponseEntity<JSONResponse> addUserByClientManager(User userAccount) {
		JSONResponse jsonResponse = new JSONResponse();
		UserInfo userInfoSaved = null;
		try {
//			JSONObject jsonObject = new JSONObject(json);
			User user = new User();
			user.setEmail(userAccount.getEmail());
			user.setPassword(userAccount.getPassword());

			User userEmail = repository.findUserByEmail(userAccount.getEmail());
			if (userEmail != null) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseString("El usuario con este email ya ah sido registrado ");
				jsonResponse.setResponseObject(null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			User userPhone = repository.findUserByPhone(userAccount.getFkUserInfo().getPhone());
			if (userPhone != null) {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseString("El usuario con este telefono ya ah sido registrado ");
				jsonResponse.setResponseObject(null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			userInfoSaved = repositoryInf.save(UserInfo.builder().name(userAccount.getFkUserInfo().getName())
					.surname(userAccount.getFkUserInfo().getSurname()).phone(userAccount.getFkUserInfo().getPhone())
					.fkGender(genderReposity.findByGenderName(userAccount.getFkUserInfo().getFkGender().getGender()))
					.build());

			user.setFkUserInfo(userInfoSaved);
			user.setFkUserType(repositoryTeype.findByUserType(userAccount.getFkUserType().getType()));

			jsonResponse.setResponseBoolean(true);
			jsonResponse.setResponseString("Registro de usuario exitoso");
			jsonResponse.setResponseObject(repository.save(user));

		} catch (Exception e) {
			if (userInfoSaved != null) {
				repositoryInf.delete(userInfoSaved);
			}
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseString("Error al registrar el usuario " + e);
			jsonResponse.setResponseObject(null);
			LOGGER.error(jsonResponse.getResponseString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}

	@Override
	public ResponseEntity<JSONResponse> login(String email, String password) {
		JSONResponse jsonResponse = new JSONResponse();
		try {
			User user = new User();

			user = repository.findByUserAndUserPass(email,
					password);
			if (user != null) {
				user.setPassword("");
				jsonResponse.setResponseObject(user);
				jsonResponse.setResponseBoolean(true);
				jsonResponse.setResponseString("Bienvenido " + user.getFkUserInfo().getName());

			} else {
				jsonResponse.setResponseBoolean(false);
				jsonResponse.setResponseString("No hay resultados con esas credenciales");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}

		} catch (Exception e) {
			jsonResponse.setResponseBoolean(false);
			jsonResponse.setResponseString("ERROR  en login: " + e);
			jsonResponse.setResponseObject(null);
			LOGGER.error("login " + e);
		}
		return ResponseEntity.ok(jsonResponse);

	}

}
