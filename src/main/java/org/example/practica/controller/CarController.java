package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.CarDTO;
import org.example.practica.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carService")
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO) {

    }
}
