package com.authAPI.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authAPI.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
	
}
