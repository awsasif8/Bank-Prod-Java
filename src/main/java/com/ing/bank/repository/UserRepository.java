package com.ing.bank.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
