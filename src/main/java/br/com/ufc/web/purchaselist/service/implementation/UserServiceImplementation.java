package br.com.ufc.web.purchaselist.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.web.purchaselist.entity.UserEntity;
import br.com.ufc.web.purchaselist.repository.UserRepository;
import br.com.ufc.web.purchaselist.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity save(UserEntity user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<UserEntity> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public UserEntity findById(long id) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		
		if (user.isEmpty()) {
			return null;
		}
		
		return user.get();
	}

	@Override
	public UserEntity findByEmail(String email) {
		Optional<UserEntity> user = this.userRepository.findByEmail(email);
		
		if (user.isEmpty()) {
			return null;
		}
		
		return user.get();
	}

	@Override
	public UserEntity update(UserEntity user) {
		UserEntity userUpdate = this.findById(user.getId());
		
		userUpdate.setName(user.getName());
		userUpdate.setEmail(user.getEmail());
		
		this.userRepository.save(userUpdate);
		
		return userUpdate;
	}

	@Override
	public boolean delete(long id) {
		UserEntity user = this.findById(id);
		
		if (user == null) {
			return false;
		}
		
		try {
			this.userRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean existsByEmail(String email) {
		return this.userRepository.existsByEmail(email);
	}

}
