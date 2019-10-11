package com.Ajanan.DefectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ajanan.DefectTracker.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByUserId(String userId);
}