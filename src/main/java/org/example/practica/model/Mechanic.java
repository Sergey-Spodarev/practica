package org.example.practica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Mechanic {
    @Id
    private Long id;

    private String name;
    private String specialization;
    private LocalDate hireDate;

    @ManyToMany(mappedBy = "mechanics")
    private Set<Order> orders;
}
