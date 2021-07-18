package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.MarketplaceModel;

public interface MarketplaceRepository extends JpaRepository<MarketplaceModel, Long> {

}
