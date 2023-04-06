package com.authAPI.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authAPI.api.dto.Login;
import com.authAPI.api.model.Usuario;
import com.authAPI.api.service.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public String login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(login.login(), login.password());
		
		Authentication authentication = authenticationManager.
				authenticate(authenticationToken);
		
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		return tokenService.gerarToken(usuario);
	}
	
}
