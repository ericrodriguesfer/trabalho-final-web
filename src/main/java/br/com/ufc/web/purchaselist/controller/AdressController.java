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

import br.com.ufc.web.purchaselist.entity.AdressModel;
import br.com.ufc.web.purchaselist.model.request.AdressRequestModel;
import br.com.ufc.web.purchaselist.model.response.AdressResponseModel;
import br.com.ufc.web.purchaselist.service.implementation.AdressServiceImplementation;

@RestController
public class AdressController {

	@Autowired
	private AdressServiceImplementation adressService;
	
	@PostMapping(value = "/adress")
	@Transactional
	public ResponseEntity<Object> addAdress(@RequestBody @Valid AdressRequestModel adressRegister) {
		AdressModel adress = adressRegister.toModel();
		this.adressService.save(adress);
		AdressResponseModel adressResponse = new AdressResponseModel(adress.getId(), adress.getStreet(), adress.getNumber(), adress.getNeighborhood(), adress.getCity());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adressResponse);
	}
	
	@GetMapping(value = "/adress")
	public ResponseEntity<Object> listAllAdress() {
		List<AdressResponseModel> adressResponse = new ArrayList<AdressResponseModel>();
		List<AdressModel> adresses = this.adressService.findAll();
		
		if (adresses.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exists adresses registered");
		}
		
		for (AdressModel adress : adresses) {
			adressResponse.add(new AdressResponseModel(adress.getId(), adress.getStreet(), adress.getNumber(), adress.getNeighborhood(), adress.getCity()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(adressResponse);
	}
	
	@GetMapping(value = "/adress/{id}")
	public ResponseEntity<Object> listAdressById(@NotBlank @PathVariable long id) {
		AdressModel adress = this.adressService.findById(id);
		
		if (adress == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adress not found by this id repassed");
		}
		
		AdressResponseModel adressResponse = new AdressResponseModel(adress.getId(), adress.getStreet(), adress.getNumber(), adress.getNeighborhood(), adress.getCity());
		
		return ResponseEntity.status(HttpStatus.OK).body(adressResponse);
	}
	
	@PutMapping(value = "/adress/{id}")
	@Transactional
	public ResponseEntity<Object> updateAdress(@NotBlank @PathVariable long id, @RequestBody AdressRequestModel adressUpdate) {
		AdressModel adress = this.adressService.findById(id);
		
		adress.setStreet(adressUpdate.getStreet());
		adress.setNumber(adressUpdate.getNumber());
		adress.setNeighborhood(adressUpdate.getNeighborhood());
		adress.setCity(adressUpdate.getCity());
		
		AdressModel adressUpdated = this.adressService.update(adress);
		AdressResponseModel adressResponse = new AdressResponseModel(adressUpdated.getId(), adressUpdated.getStreet(), adressUpdated.getNumber(), adressUpdated.getNeighborhood(), adressUpdated.getCity());
		
		return ResponseEntity.status(HttpStatus.OK).body(adressResponse);
	}
	
	@DeleteMapping(value = "/adress/{id}")
	@Transactional
	public ResponseEntity<Object> deleteAdress(@NotBlank @PathVariable long id) {
		boolean response = this.adressService.delete(id);
		
		if (response) {
			return ResponseEntity.status(HttpStatus.OK).body("Adress deleted of success");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail in deleted adress");
	}
	
}
