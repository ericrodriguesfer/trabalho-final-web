package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.MarketplaceModel;

public interface MarketplaceService {

	MarketplaceModel save(MarketplaceModel marketplace);
	List<MarketplaceModel> findAll();
	MarketplaceModel findById(long id);
	MarketplaceModel update(MarketplaceModel marketplace);
	boolean delete(long id);
	
}
