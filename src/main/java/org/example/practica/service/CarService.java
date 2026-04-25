package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;
}
