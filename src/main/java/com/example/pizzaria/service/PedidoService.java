package com.example.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzaria.entity.Menu;
import com.example.pizzaria.entity.Pedido;
import com.example.pizzaria.repository.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido gerarPedido(Pedido pedido) {
        double valorTotal = calcularValorTotal(pedido.getItem());
        pedido.setValor(valorTotal);
        pedido.setQtd(pedido.getItem().size());

        return pedidoRepository.save(pedido);
    }

    public void enviarPedido(Pedido pedido) {
        System.out.println("Pedido enviado: " + pedido.getId());
    }

    private double calcularValorTotal(List<Menu> itens) {
        return itens.stream()
            .mapToDouble(Menu::getValor)
            .sum();
    }
    public void excluirTodosPedido() {
        pedidoRepository.deleteAll();
    }
}
