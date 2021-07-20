package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.MarketplaceEntity;

public interface MarketplaceRepository extends JpaRepository<MarketplaceEntity, Long> {
	
}
