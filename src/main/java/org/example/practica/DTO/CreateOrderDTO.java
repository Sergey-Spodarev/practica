package org.example.practica.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO {
    private Long carId;
    private List<Long> mechanicIds;
}
