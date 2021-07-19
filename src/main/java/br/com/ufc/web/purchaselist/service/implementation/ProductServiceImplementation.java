package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.ProductModel;
import br.com.ufc.web.purchaselist.repository.ProductRepository;
import br.com.ufc.web.purchaselist.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductModel save(ProductModel product) {
		return this.productRepository.save(product);
	}

	@Override
	public List<ProductModel> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public ProductModel findById(long id) {
		Optional<ProductModel> product = this.productRepository.findById(id);
		
		if (product.isEmpty()) {
			return null;
		}
		
		return product.get();
	}

	@Override
	public ProductModel update(ProductModel product) {
		ProductModel productUpdate = this.findById(product.getId());
		
		productUpdate.setName(product.getName());
		productUpdate.setDescription(product.getDescription());
		productUpdate.setPrice(product.getPrice());
		
		this.productRepository.save(productUpdate);
		
		return productUpdate;
	}

	@Override
	public boolean delete(long id) {
		ProductModel product = this.findById(id);
		
		if (product == null) {
			return false;
		}
		try {
			this.productRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
 	}

}
