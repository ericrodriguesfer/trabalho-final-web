package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.MarketplaceModel;
import br.com.ufc.web.purchaselist.repository.MarketplaceRepository;
import br.com.ufc.web.purchaselist.service.MarketplaceService;

@Service
public class MarketplaceServiceImplementation implements MarketplaceService{
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Override
	public MarketplaceModel save(MarketplaceModel marketplace) {
		return this.marketplaceRepository.save(marketplace);
	}

	@Override
	public List<MarketplaceModel> findAll() {
		return this.marketplaceRepository.findAll();
	}

	@Override
	public MarketplaceModel findById(long id) {
		Optional<MarketplaceModel> marketplace = this.marketplaceRepository.findById(id);
		
		if (marketplace.isEmpty()) {
			return null;
		}
		
		return marketplace.get();
	}

	@Override
	public MarketplaceModel update(MarketplaceModel marketplace) {
		MarketplaceModel marketplaceUpdate = this.findById(marketplace.getId());
		
		marketplaceUpdate.setName(marketplace.getName());
		
		this.marketplaceRepository.save(marketplaceUpdate);
		
		return marketplaceUpdate;
	}

	@Override
	public boolean delete(long id) {
		MarketplaceModel marketplace = this.findById(id);
		
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
