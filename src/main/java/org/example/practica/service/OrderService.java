package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
}
