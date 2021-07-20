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

import br.com.ufc.web.purchaselist.entity.MarketplaceModel;
import br.com.ufc.web.purchaselist.entity.ProductModel;
import br.com.ufc.web.purchaselist.model.request.ProductRequestModel;
import br.com.ufc.web.purchaselist.model.request.ProductUpdateRequestModel;
import br.com.ufc.web.purchaselist.model.response.MarketplaceSimplifiedResponseModel;
import br.com.ufc.web.purchaselist.model.response.ProductResponseModel;
import br.com.ufc.web.purchaselist.service.implementation.MarketplaceServiceImplementation;
import br.com.ufc.web.purchaselist.service.implementation.ProductServiceImplementation;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImplementation productService;
	
	@Autowired
	private MarketplaceServiceImplementation marketplaceService;
	
	@PostMapping(value = "/product")
	@Transactional
	public ResponseEntity<Object> addProduct(@RequestBody @Valid ProductRequestModel productRegister) {
		MarketplaceModel marketplace = this.marketplaceService.findById(productRegister.getIdMarketplace());
		
		if (marketplace == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Marketplace this product is invalid");
		}
		
		ProductModel product = productRegister.toModel(marketplace);
		this.productService.save(product);
		
		ProductResponseModel productResponse = new ProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), new MarketplaceSimplifiedResponseModel(product.getMarketplace().getName()));
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);	
	}
	
	@GetMapping(value = "/product")
	public ResponseEntity<Object> listAllProducts() {
		List<ProductResponseModel> productsResponse = new ArrayList<ProductResponseModel>();
		List<ProductModel> products = this.productService.findAll();
		
		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exists products registered");
		}
		
		for (ProductModel product : products) {
			productsResponse.add(new ProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), new MarketplaceSimplifiedResponseModel(product.getMarketplace().getName())));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(productsResponse);
	}
	
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Object> listProductById(@NotBlank @PathVariable long id) {
		ProductModel product = this.productService.findById(id);
		
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found by this id repassed");
		}
		
		ProductResponseModel productResponse = new ProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), new MarketplaceSimplifiedResponseModel(product.getMarketplace().getName()));
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}
	
	@PutMapping(value = "/product/{id}")
	@Transactional
	public ResponseEntity<Object> updateProduct(@NotBlank @PathVariable long id, @RequestBody ProductUpdateRequestModel productUpdate) {
		ProductModel product = this.productService.findById(id);
		
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for update");
		}
		
		product.setName(productUpdate.getName());
		product.setDescription(productUpdate.getDescription());
		product.setPrice(productUpdate.getPrice());
		
		ProductModel productUpdated = this.productService.update(product);
		ProductResponseModel productResponse = new ProductResponseModel(productUpdated.getId(), productUpdated.getName(), productUpdated.getDescription(), productUpdated.getPrice(), new MarketplaceSimplifiedResponseModel(productUpdated.getMarketplace().getName()));
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}
	
	@DeleteMapping(value = "/product/{id}")
	@Transactional
	public ResponseEntity<Object> deleteProduct(@NotBlank @PathVariable long id) {
		boolean response = this.productService.delete(id);
		
		if (response) {
			return ResponseEntity.status(HttpStatus.OK).body("Product deleted of success");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail in deleted product");
	}
	
}
