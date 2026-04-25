package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carService")
@AllArgsConstructor
public class CarController {
    private final CarService carService;
}
