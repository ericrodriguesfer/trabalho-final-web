package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.ProductModel;

public interface ProductService {

	ProductModel save(ProductModel product);
	List<ProductModel> findAll();
	ProductModel findById(long id);
	ProductModel update(ProductModel product);
	boolean delete(long id);
	
}
