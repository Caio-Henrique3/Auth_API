package com.authAPI.api.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.authAPI.api.model.Produto;
import com.authAPI.api.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	
	@DeleteMapping("/{idProduto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RolesAllowed("ROLE_ADMIN")
	public void deletarProduto(@PathVariable Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}
	
}
