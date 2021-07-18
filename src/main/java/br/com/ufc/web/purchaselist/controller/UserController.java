package br.com.ufc.web.purchaselist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.web.purchaselist.entity.UserModel;
import br.com.ufc.web.purchaselist.model.request.UserRequestModel;
import br.com.ufc.web.purchaselist.model.request.UserUpdateRequestModel;
import br.com.ufc.web.purchaselist.model.response.UserResponseModel;
import br.com.ufc.web.purchaselist.service.implementation.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	private UserServiceImplementation userService;
	
	@PostMapping(value = "/user")
	@Transactional
	public ResponseEntity<Object> addUser(@RequestBody @Valid UserRequestModel userRegister) {
		if (this.userService.existsByEmail(userRegister.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Exists other account with this email");
		}
		
		UserModel user = userRegister.toModel();
		this.userService.save(user);
		UserResponseModel userResponse = new UserResponseModel(user.getId(), user.getName(), user.getEmail(), user.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<Object> listAllUsers() {
		List<UserResponseModel> usersResponse = new ArrayList<UserResponseModel>();
		List<UserModel> users = this.userService.findAll();
		
		if (users.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exists users registered");
		}
		
		for (UserModel user : users) {
			usersResponse.add(new UserResponseModel(user.getId(), user.getName(), user.getEmail(), user.getPassword()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(usersResponse);
	}
	
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<Object> listUserById(@NotBlank @PathVariable long id) {
		UserModel user = this.userService.findById(id);
		
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found by this id repassed");
		}
		
		UserResponseModel userResponse = new UserResponseModel(user.getId(), user.getName(), user.getEmail(), user.getPassword());
		
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
	
	@GetMapping(value = "/user/email/{email}")
	public ResponseEntity<Object> listUserByEmail(@NotBlank @PathVariable String email) {
		UserModel user = this.userService.findByEmail(email);
		
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found by this e-mail repassed");
		}
		
		UserResponseModel userResponse = new UserResponseModel(user.getId(), user.getName(), user.getEmail(), user.getPassword());
		
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
	
	@PutMapping(value = "/user/{id}")
	@Transactional
	public ResponseEntity<Object> updateUser(@NotBlank @PathVariable long id, @RequestBody @Valid UserUpdateRequestModel userUpdate) {
		UserModel user = this.userService.findById(id);
		
		user.setName(userUpdate.getName());
		user.setEmail(userUpdate.getEmail());
		
		UserModel userUpdated = this.userService.update(user);
		UserResponseModel userResponse = new UserResponseModel(userUpdated.getId(), userUpdated.getName(), userUpdated.getEmail(), userUpdated.getPassword());
		
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
	
	@DeleteMapping(value = "/user/{id}")
	@Transactional
	public ResponseEntity<Object> deleteUser(@NotBlank @PathVariable long id) {
		boolean response = this.userService.delete(id);
		
		if (response) {
			return ResponseEntity.status(HttpStatus.OK).body("User deleted of success");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail in deleted user");
	}
	
}
