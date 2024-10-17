package com.example.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzaria.entity.Cadastro;
import com.example.pizzaria.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository cadastroRepository;
	
    public void excluirTodosCadastro() {
        cadastroRepository.deleteAll();
    }
    
    public void gerarCadstro(Cadastro login) {
    	cadastroRepository.save(login);
    }
}
