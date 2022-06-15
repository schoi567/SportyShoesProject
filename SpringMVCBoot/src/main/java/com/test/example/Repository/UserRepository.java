package com.test.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.example.entity.*;

public interface UserRepository extends JpaRepository<Customers, Long> {
	 
}