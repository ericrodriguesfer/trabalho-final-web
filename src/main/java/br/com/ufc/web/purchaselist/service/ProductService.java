package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.ProductEntity;

public interface ProductService {

	ProductEntity save(ProductEntity product);
	List<ProductEntity> findAll();
	ProductEntity findById(long id);
	ProductEntity update(ProductEntity product);
	boolean delete(long id);
	
}
