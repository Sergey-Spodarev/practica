package org.example.practica.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime createdAt;
    private String status;
    private BigDecimal totalCost;
    private CarDTO car;
    private List<MechanicDTO> mechanics;
    private List<ServiceItemDTO> serviceItems;
}
