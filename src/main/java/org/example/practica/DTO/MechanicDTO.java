package org.example.practica.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MechanicDTO {
    private Long id;
    private String name;
    private String specialization;
    private LocalDate hireDate;
}
