package com.mini.miniServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.miniServer.domain.Common;

public interface CommonRepository extends JpaRepository<Common, Integer> {

	int countByUsername(String username);
	
}
