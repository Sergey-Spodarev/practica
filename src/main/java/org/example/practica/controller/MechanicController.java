package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.service.MechanicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mechanicService")
@AllArgsConstructor
public class MechanicController {
    private final MechanicService mechanicService;
}
