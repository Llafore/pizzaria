package com.example.pizzaria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.pizzaria.controller.MenuController;
import com.example.pizzaria.controller.PedidoController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cadastro")

public class Cadastro implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String nome;
		private String cpf;
		private String endereco;
		private String telefone;
		private long idade;

	    public Cadastro() {}

	    public Cadastro(String nome, String cpf, String endereco, String telefone, long idade) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.endereco = endereco;
	        this.telefone = telefone;
	        this.idade = idade;
	    }
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public long getIdade() {
			return idade;
		}
		public void setIdade(long idade) {
			this.idade = idade;
		}	
}
