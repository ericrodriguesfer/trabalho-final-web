package br.com.ufc.web.purchaselist.service;

import java.util.List;

import br.com.ufc.web.purchaselist.entity.UserModel;

public interface UserService {
	
	UserModel save(UserModel user);
	List<UserModel> findAll();
	UserModel findById(long id);
	UserModel findByEmail(String email);
	UserModel update(UserModel user);
	boolean existsByEmail(String email);
	boolean delete(long id);
	
}
