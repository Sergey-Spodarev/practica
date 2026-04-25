package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.ServiceItemDTO;
import org.example.practica.service.ServiceItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/serviceItem")
@AllArgsConstructor
public class ServiceItemController {
    private final ServiceItemService serviceItemService;

    @GetMapping
    public ResponseEntity<List<ServiceItemDTO>> getAll() {
        return ResponseEntity.ok(serviceItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceItemDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceItemService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceItemDTO> create(@RequestBody ServiceItemDTO serviceItemDTO) {
        return new ResponseEntity<>(serviceItemService.create(serviceItemDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceItemDTO> update(@PathVariable Long id, @RequestBody ServiceItemDTO serviceItemDTO) {
        return ResponseEntity.ok(serviceItemService.update(id, serviceItemDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
