package br.com.ufc.web.purchaselist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.web.purchaselist.entity.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
