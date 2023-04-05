package com.authAPI.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authAPI.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	
}
