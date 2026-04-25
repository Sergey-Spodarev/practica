package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.service.ServiceItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/serviceItem")
@AllArgsConstructor
public class ServiceItemController {
    private final ServiceItemService serviceItemService;
}
