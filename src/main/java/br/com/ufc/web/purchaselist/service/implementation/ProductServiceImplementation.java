package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.ProductEntity;
import br.com.ufc.web.purchaselist.repository.ProductRepository;
import br.com.ufc.web.purchaselist.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity save(ProductEntity product) {
		return this.productRepository.save(product);
	}

	@Override
	public List<ProductEntity> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public ProductEntity findById(long id) {
		Optional<ProductEntity> product = this.productRepository.findById(id);
		
		if (product.isEmpty()) {
			return null;
		}
		
		return product.get();
	}

	@Override
	public ProductEntity update(ProductEntity product) {
		ProductEntity productUpdate = this.findById(product.getId());
		
		productUpdate.setName(product.getName());
		productUpdate.setDescription(product.getDescription());
		productUpdate.setPrice(product.getPrice());
		
		this.productRepository.save(productUpdate);
		
		return productUpdate;
	}

	@Override
	public boolean delete(long id) {
		ProductEntity product = this.findById(id);
		
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
