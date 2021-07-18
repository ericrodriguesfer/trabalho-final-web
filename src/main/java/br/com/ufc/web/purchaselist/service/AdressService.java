package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.AdressModel;

public interface AdressService {

	AdressModel save(AdressModel adress);
	List<AdressModel> findAll();
	AdressModel findById(long id);
	AdressModel update(AdressModel adress);
	boolean existsById(long id);
	boolean delete(long id);
	
}
