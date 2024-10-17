package com.example.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzaria.entity.Menu;
import com.example.pizzaria.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;
	
    public void excluirTodosMenu() {
    	menuRepository.deleteAll();
    }
    
    public void gerarMenu(Menu item) {
    	menuRepository.save(item);
    }
}
