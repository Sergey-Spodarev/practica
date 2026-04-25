package org.example.practica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String brand;
    private String model;
    private String ownerName;
    private String ownerPhone;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Order> orders;
}
