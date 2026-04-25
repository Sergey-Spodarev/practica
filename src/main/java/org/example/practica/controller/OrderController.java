package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.CreateOrderDTO;
import org.example.practica.DTO.OrderDTO;
import org.example.practica.DTO.ServiceItemDTO;
import org.example.practica.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderService")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTO createOrderDTO) {
        return new ResponseEntity<>(orderService.create(createOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody CreateOrderDTO updateDTO) {
        return ResponseEntity.ok(orderService.update(id, updateDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{orderId}/items/add")
    public ResponseEntity<OrderDTO> addServiceItem(@PathVariable Long orderId, @RequestBody ServiceItemDTO serviceItemDTO) {
        return ResponseEntity.ok(orderService.addServiceItem(orderId, serviceItemDTO));
    }
}
