package com.api.pedido.service;


import com.api.pedido.model.Order;
import com.api.pedido.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
    }
}
