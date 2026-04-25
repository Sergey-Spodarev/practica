package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.repository.MechanicRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;
}
