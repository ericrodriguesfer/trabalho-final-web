package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.AdressModel;

public interface AdressRepository extends JpaRepository<AdressModel, Long> {
	
	boolean existsById(long id);
	
}
