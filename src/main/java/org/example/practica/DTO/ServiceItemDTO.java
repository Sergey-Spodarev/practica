package org.example.practica.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceItemDTO {
    private Long id;
    private String description;
    private BigDecimal price;
}
