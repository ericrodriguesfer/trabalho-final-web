package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
