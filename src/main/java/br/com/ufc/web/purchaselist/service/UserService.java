package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.UserEntity;

public interface UserService {
	
	UserEntity save(UserEntity user);
	List<UserEntity> findAll();
	UserEntity findById(long id);
	UserEntity findByEmail(String email);
	UserEntity update(UserEntity user);
	boolean existsByEmail(String email);
	boolean delete(long id);
	
}
