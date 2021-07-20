package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.AdressEntity;

public interface AdressRepository extends JpaRepository<AdressEntity, Long> {
	
	boolean existsById(long id);
	
}
