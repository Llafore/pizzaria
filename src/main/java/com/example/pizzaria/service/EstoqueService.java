package com.example.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzaria.repository.EstoqueRepository;

@Service
public class EstoqueService {
	@Autowired
	private EstoqueRepository estoqueRepository;
	
    public void excluirTodosCadastro() {
    	estoqueRepository.deleteAll();
    }
}
