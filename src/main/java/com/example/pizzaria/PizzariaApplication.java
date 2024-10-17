package com.example.pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pizzaria.entity.Cadastro;
import com.example.pizzaria.entity.Menu;
import com.example.pizzaria.entity.Pedido;
import com.example.pizzaria.service.CadastroService;
import com.example.pizzaria.service.EstoqueService;
import com.example.pizzaria.service.MenuService;
import com.example.pizzaria.service.PedidoService;

@SpringBootApplication
public class PizzariaApplication implements CommandLineRunner{
    @Autowired
    private CadastroService cadastroService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
    private MenuService menuService;
	@Autowired
	private EstoqueService estoqueService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
		}
	
	@Override
	public void run(String... args) throws Exception {
        pedidoService.excluirTodosPedido();
        cadastroService.excluirTodosCadastro();
        menuService.excluirTodosMenu();
        
        Cadastro usuario1 = new Cadastro("Tarso","777.777.777-77","Avenida Paulista","(11) 91234-1234",69);
        Cadastro usuario2 = new Cadastro("Rogerio Ceni","242.424.242-42","Morumbis","(11) 90633-0633",50);
        Cadastro usuario3 = new Cadastro("Zac Alfredo","111.111.111-11","Rua Elba","(11) 99876-5432",69);
        
        Menu pizzaCalabresa  = new Menu("Calabresa",50.00, "Fantastica pizza de calabresa com linguiça calabresa toscana e molho barbecue");
        Menu pizzaMussarela  = new Menu("Mussarela ",45.00, "Classica pizza de mussarela com molho de tomate");
        Menu pizzaPeperonni  = new Menu("Peperoni ",70.00, "Ousada pizza com rodelas de peperoi, queijo mussarela e molho de tomate");
        Menu pizzaPorutuguesa= new Menu("Portuguesa", 65.00, "Pizza que desce igual a portuguesa santista");
        
        List<Menu> itensPed1 = new ArrayList<>();
        itensPed1.add(pizzaPorutuguesa);
//        List<Menu> itensPed2 = new ArrayList<>();
//        itensPed2.add(pizzaMussarela);
//        itensPed2.add(pizzaMussarela);
//        List<Menu> itensPed3 = new ArrayList<>();
//        itensPed3.add(pizzaCalabresa);
//        itensPed3.add(pizzaPeperonni);
        
        Pedido pedido1 = new Pedido("", itensPed1, usuario1);
//        Pedido pedido2 = new Pedido("", itensPed2, usuario2);
//        Pedido pedido3 = new Pedido("", itensPed3, usuario3);
        
        cadastroService.gerarCadstro(usuario1);
        cadastroService.gerarCadstro(usuario2);
        cadastroService.gerarCadstro(usuario3);
        
        menuService.gerarMenu(pizzaCalabresa);
        menuService.gerarMenu(pizzaMussarela);
        menuService.gerarMenu(pizzaPeperonni);
        menuService.gerarMenu(pizzaPorutuguesa);
        
//        pedidoService.gerarPedido(pedido1);
//        pedidoService.gerarPedido(pedido2);
//        pedidoService.gerarPedido(pedido3);
        
    }
}
