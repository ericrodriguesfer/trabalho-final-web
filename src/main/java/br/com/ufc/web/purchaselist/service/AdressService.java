package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.AdressEntity;

public interface AdressService {

	AdressEntity save(AdressEntity adress);
	List<AdressEntity> findAll();
	AdressEntity findById(long id);
	AdressEntity update(AdressEntity adress);
	boolean existsById(long id);
	boolean delete(long id);
	
}
