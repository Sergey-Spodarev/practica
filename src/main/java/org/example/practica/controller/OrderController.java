package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderService")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
