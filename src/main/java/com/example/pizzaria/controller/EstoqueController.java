package com.example.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzaria.entity.Estoque;
import com.example.pizzaria.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EstoqueController {
	@Autowired
	private EstoqueRepository repository;
	
   
	@PostMapping
	public ResponseEntity<Estoque> post (@RequestBody Estoque estoque){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(estoque));
	}
	
	@GetMapping
    public ResponseEntity<List<Estoque>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getById(@PathVariable("id") Long id) {
        Optional<Estoque> estoque = repository.findById(id);
        return estoque.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable("id") Long id, @RequestBody Estoque updatedEstoque) {
        return repository.findById(id).map(estoque -> {
            if (updatedEstoque.getNome() != null) estoque.setNome(updatedEstoque.getNome());
            if (updatedEstoque.getQuantidade() != null) estoque.setQuantidade(updatedEstoque.getQuantidade());
            if (updatedEstoque.getDescritivo() != null) estoque.setDescritivo(updatedEstoque.getDescritivo());
            if (updatedEstoque.getFornecedor() != null) estoque.setFornecedor(updatedEstoque.getFornecedor());

            Estoque updated = repository.save(estoque);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable("id") Long id) {
        Optional<Estoque> estoque = repository.findById(id);
        if (estoque.isPresent()) {
            repository.delete(estoque.get());
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }
    
    @DeleteMapping("/deleteAll")// CUIDADO AO USAR ESTA CARALHA!!
    public ResponseEntity<Void> deleteAllEstoques() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}

