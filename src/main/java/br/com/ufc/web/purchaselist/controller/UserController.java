package br.com.ufc.web.purchaselist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.web.purchaselist.model.request.UserRequestModel;
import br.com.ufc.web.purchaselist.model.response.UserResponseModel;
import br.com.ufc.web.purchaselist.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<UserResponseModel> addUser(@RequestBody @Valid UserRequestModel userRegister) {
		return null;
	}
	
}
