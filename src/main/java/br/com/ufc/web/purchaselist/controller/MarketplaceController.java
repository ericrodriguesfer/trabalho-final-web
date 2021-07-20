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
import br.com.ufc.web.purchaselist.entity.MarketplaceModel;
import br.com.ufc.web.purchaselist.entity.ProductModel;
//import br.com.ufc.web.purchaselist.entity.UserModel;
import br.com.ufc.web.purchaselist.model.request.MarketplaceRequestModel;
import br.com.ufc.web.purchaselist.model.request.MarketplaceUpdateRequestModel;
import br.com.ufc.web.purchaselist.model.response.AdressResponseModel;
import br.com.ufc.web.purchaselist.model.response.MarketplaceResponseModel;
//import br.com.ufc.web.purchaselist.model.response.UserSimplifiedResponseModel;
import br.com.ufc.web.purchaselist.service.implementation.AdressServiceImplementation;
import br.com.ufc.web.purchaselist.service.implementation.MarketplaceServiceImplementation;
import br.com.ufc.web.purchaselist.service.implementation.ProductServiceImplementation;
//import br.com.ufc.web.purchaselist.service.implementation.UserServiceImplementation;

@RestController
public class  MarketplaceController {

	@Autowired
	private MarketplaceServiceImplementation marketplaceService;
	
//	@Autowired
//	private UserServiceImplementation userService;
	
	@Autowired
	private AdressServiceImplementation adressService;
	
	@Autowired
	private ProductServiceImplementation productService;
	
	@PostMapping(value = "/marketplace")
	@Transactional
	public ResponseEntity<Object> addMarketplace(@RequestBody @Valid MarketplaceRequestModel marketplaceRegister) {
//		UserModel user = this.userService.findById(marketplaceRegister.getIdUser());
//		
//		if (user == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User this marketplace is invalid");
//		}
		
		AdressModel adress = this.adressService.findById(marketplaceRegister.getIdAdress());
		
		if (adress == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adress this marketplace is invalid");
		}
		
		MarketplaceModel marketplace = marketplaceRegister.toModel(adress);
		this.marketplaceService.save(marketplace);
		
		MarketplaceResponseModel marketplaceResponse = new MarketplaceResponseModel(marketplace.getId(), marketplace.getName(), marketplace.getQuantityProducts(), new AdressResponseModel(adress.getId(), adress.getStreet(), adress.getNumber(), adress.getNeighborhood(), adress.getCity()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(marketplaceResponse);
	}	
	
	@GetMapping(value = "/marketplace")
	public ResponseEntity<Object> listAllMarketplaces() {
		List<MarketplaceResponseModel> marketplacesResponse = new ArrayList<MarketplaceResponseModel>();
		List<MarketplaceModel> marketplaces = this.marketplaceService.findAll();
		
		if (marketplaces.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exists marketplaces registered");
		}
		
		for (MarketplaceModel marketplace : marketplaces) {
			marketplacesResponse.add(new MarketplaceResponseModel(marketplace.getId(), marketplace.getName(), marketplace.getQuantityProducts(), new AdressResponseModel(marketplace.getAdress().getId(), marketplace.getAdress().getStreet(), marketplace.getAdress().getNumber(), marketplace.getAdress().getNeighborhood(), marketplace.getAdress().getCity())));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(marketplacesResponse);
	}
	
	@GetMapping(value = "/marketplace/{id}")
	public ResponseEntity<Object> listMarketplaceById(@NotBlank @PathVariable long id) {
		MarketplaceModel marketplace = this.marketplaceService.findById(id);
		
		if (marketplace == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marketplace not found by this id repassed");
		}
		
		MarketplaceResponseModel marketplaceResponse = new MarketplaceResponseModel(marketplace.getId(), marketplace.getName(), marketplace.getQuantityProducts(), new AdressResponseModel(marketplace.getAdress().getId(), marketplace.getAdress().getStreet(), marketplace.getAdress().getNumber(), marketplace.getAdress().getNeighborhood(), marketplace.getAdress().getCity()));
		
		return ResponseEntity.status(HttpStatus.OK).body(marketplaceResponse);
	}
	
	@PutMapping(value = "/marketplace/{id}")
	@Transactional
	public ResponseEntity<Object> updateMarketplace(@NotBlank @PathVariable long id, @RequestBody MarketplaceUpdateRequestModel marketplaceUpdate) {
		MarketplaceModel marketplace = this.marketplaceService.findById(id);
		
		if (marketplace == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marketplace not found for update");
		}
		
		marketplace.setName(marketplaceUpdate.getName());
		
		MarketplaceModel marketplaceUpdated = this.marketplaceService.update(marketplace);
		MarketplaceResponseModel marketplaceResponse = new MarketplaceResponseModel(marketplaceUpdated.getId(), marketplaceUpdated.getName(), marketplaceUpdated.getQuantityProducts(), new AdressResponseModel(marketplaceUpdated.getAdress().getId(), marketplaceUpdated.getAdress().getStreet(), marketplaceUpdated.getAdress().getNumber(), marketplaceUpdated.getAdress().getNeighborhood(), marketplaceUpdated.getAdress().getCity()));
		
		return ResponseEntity.status(HttpStatus.OK).body(marketplaceResponse);
	}
	
	@DeleteMapping(value = "/marketplace/{id}")
	@Transactional
	public ResponseEntity<Object> deleteMarketplace(@NotBlank @PathVariable long id) {
		MarketplaceModel marketplace = this.marketplaceService.findById(id);
		List<ProductModel> products = this.productService.findAll();
		List<ProductModel> productsDelete = new ArrayList<ProductModel>();
		
		for (ProductModel product : products) {
			if (product.getMarketplace().getId() == id) {
				productsDelete.add(product);
			}
		}
		
		for (ProductModel product : productsDelete) {
			this.productService.delete(product.getId());
		}
		
		boolean response = this.marketplaceService.delete(id);
		
		if (response) {
			this.adressService.delete(marketplace.getAdress().getId());
			return ResponseEntity.status(HttpStatus.OK).body("Marketplace deleted of success");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail in deleted marketplace");
	}
	
}
