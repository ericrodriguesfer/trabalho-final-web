package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.MarketplaceEntity;
import br.com.ufc.web.purchaselist.repository.MarketplaceRepository;
import br.com.ufc.web.purchaselist.service.MarketplaceService;

@Service
public class MarketplaceServiceImplementation implements MarketplaceService{
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Override
	public MarketplaceEntity save(MarketplaceEntity marketplace) {
		return this.marketplaceRepository.save(marketplace);
	}

	@Override
	public List<MarketplaceEntity> findAll() {
		return this.marketplaceRepository.findAll();
	}

	@Override
	public MarketplaceEntity findById(long id) {
		Optional<MarketplaceEntity> marketplace = this.marketplaceRepository.findById(id);
		
		if (marketplace.isEmpty()) {
			return null;
		}
		
		return marketplace.get();
	}

	@Override
	public MarketplaceEntity update(MarketplaceEntity marketplace) {
		MarketplaceEntity marketplaceUpdate = this.findById(marketplace.getId());
		
		marketplaceUpdate.setName(marketplace.getName());
		marketplaceUpdate.setInitial(marketplace.getInitial());
		
		this.marketplaceRepository.save(marketplaceUpdate);
		
		return marketplaceUpdate;
	}
	
	@Override
	public void addCountProduct(long id) {
		MarketplaceEntity marketplace = this.findById(id);
		
		marketplace.setQuantityProducts(marketplace.getQuantityProducts() + 1);
		
		this.marketplaceRepository.save(marketplace);
	}
	


	@Override
	public boolean delete(long id) {
		MarketplaceEntity marketplace = this.findById(id);
		
		if (marketplace == null) {
			return false;
		}
		
		try {
			this.marketplaceRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
