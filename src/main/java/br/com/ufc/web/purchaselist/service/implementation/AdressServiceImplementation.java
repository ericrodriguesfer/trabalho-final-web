package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.AdressModel;
import br.com.ufc.web.purchaselist.repository.AdressRepository;
import br.com.ufc.web.purchaselist.service.AdressService;

@Service
public class AdressServiceImplementation implements AdressService {

	@Autowired
	private AdressRepository adressRepository;
	
	@Override
	public AdressModel save(AdressModel adress) {
		return this.adressRepository.save(adress);
	}

	@Override
	public List<AdressModel> findAll() {
		return this.adressRepository.findAll();
	}

	@Override
	public AdressModel findById(long id) {
		Optional<AdressModel> adress = this.adressRepository.findById(id);
		
		if (adress.isEmpty()) {
			return null;
		}
		
		return adress.get();
	}

	@Override
	public AdressModel update(AdressModel adress) {
		AdressModel adressUpdate = this.findById(adress.getId());
		
		adressUpdate.setStreet(adress.getStreet());
		adressUpdate.setNumber(adress.getNumber());
		adressUpdate.setNeighborhood(adress.getNeighborhood());
		adressUpdate.setCity(adress.getCity());
		
		this.adressRepository.save(adressUpdate);
		
		return adressUpdate;
	}

	@Override
	public boolean existsById(long id) {
		return this.adressRepository.existsById(id);
	}

	@Override
	public boolean delete(long id) {
		AdressModel adress = this.findById(id);
		
		if (adress == null) {
			return false;
		}
		
		try {
			 this.adressRepository.deleteById(id);
			 return true;
		} catch(Exception e) {
			return false;
		}
	}

}
