package org.example.practica.DTO;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private String ownerName;
    private String ownerPhone;
}
