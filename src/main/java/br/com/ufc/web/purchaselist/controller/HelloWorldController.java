package br.com.ufc.web.purchaselist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.web.purchaselist.model.model.HelloWorld;

@RestController
public class HelloWorldController {
	
	@GetMapping(value = "/")
	public ResponseEntity<HelloWorld> showAPI() {
		HelloWorld messageDefaultReturnAPI = new HelloWorld("This is route default of API, if you want to know more about the project, visit the link below.", "https://github.com/ericrodriguesfer");
		return ResponseEntity.ok().body(messageDefaultReturnAPI);
	} 
	
}
