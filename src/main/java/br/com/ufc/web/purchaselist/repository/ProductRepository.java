package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
}
