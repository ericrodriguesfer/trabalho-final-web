package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.MarketplaceEntity;

public interface MarketplaceService {

	MarketplaceEntity save(MarketplaceEntity marketplace);
	List<MarketplaceEntity> findAll();
	MarketplaceEntity findById(long id);
	MarketplaceEntity update(MarketplaceEntity marketplace);
	boolean delete(long id);
	
}
