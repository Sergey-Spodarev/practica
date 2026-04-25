package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.repository.ServiceItemRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceItemService {
    private final ServiceItemRepository serviceItemRepository;
}
