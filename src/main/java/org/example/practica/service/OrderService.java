package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.*;
import org.example.practica.model.Car;
import org.example.practica.model.Mechanic;
import org.example.practica.model.Order;
import org.example.practica.model.ServiceItem;
import org.example.practica.repository.CarRepository;
import org.example.practica.repository.MechanicRepository;
import org.example.practica.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private CarRepository carRepository;
    private MechanicRepository mechanicRepository;

    public OrderDTO create(CreateOrderDTO createDTO) {
        Order order = new Order();

        Car car = carRepository.findById(createDTO.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));
        order.setCar(car);

        Set<Mechanic> mechanics = new HashSet<>(mechanicRepository.findAllById(createDTO.getMechanicIds()));
        order.setMechanics(mechanics);

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("OPEN");
        order.setTotalCost(BigDecimal.ZERO);

        return convertToDTO(orderRepository.save(order));
    }

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public OrderDTO getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return convertToDTO(order);
    }

    public OrderDTO update(Long id, CreateOrderDTO updateDTO) {
        Order order = orderRepository.findById(id).orElseThrow();

        if (updateDTO.getCarId() != null) {
            Car car = carRepository.findById(updateDTO.getCarId()).orElseThrow();
            order.setCar(car);
        }

        if (updateDTO.getMechanicIds() != null && !updateDTO.getMechanicIds().isEmpty()) {
            Set<Mechanic> mechanics = new HashSet<>(mechanicRepository.findAllById(updateDTO.getMechanicIds()));
            order.setMechanics(mechanics);
        }

        return convertToDTO(orderRepository.save(order));
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO addServiceItem(Long orderId, ServiceItemDTO serviceItemDTO) {
        Order order = orderRepository.findById(orderId).orElseThrow();

        ServiceItem serviceItem = new ServiceItem();
        serviceItem.setDescription(serviceItemDTO.getDescription());
        serviceItem.setPrice(serviceItemDTO.getPrice());
        serviceItem.setOrder(order);

        order.getServiceItems().add(serviceItem);

        BigDecimal total = order.getServiceItems().stream()
                .map(ServiceItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalCost(total);

        return convertToDTO(orderRepository.save(order));
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalCost(order.getTotalCost());

        if (order.getCar() != null) {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(order.getCar().getId());
            carDTO.setBrand(order.getCar().getBrand());
            carDTO.setModel(order.getCar().getModel());
            carDTO.setLicensePlate(order.getCar().getLicensePlate());
            carDTO.setOwnerName(order.getCar().getOwnerName());
            carDTO.setOwnerPhone(order.getCar().getOwnerPhone());
            orderDTO.setCar(carDTO);
        }

        if (order.getMechanics() != null) {
            List<MechanicDTO> mechanicDTOs = order.getMechanics().stream().map(mechanic -> {
                MechanicDTO dto = new MechanicDTO();
                dto.setId(mechanic.getId());
                dto.setName(mechanic.getName());
                dto.setSpecialization(mechanic.getSpecialization());
                dto.setHireDate(mechanic.getHireDate());
                return dto;
            }).toList();
            orderDTO.setMechanics(mechanicDTOs);
        }

        if (order.getServiceItems() != null) {
            List<ServiceItemDTO> itemDTOs = order.getServiceItems().stream().map(item -> {
                ServiceItemDTO dto = new ServiceItemDTO();
                dto.setId(item.getId());
                dto.setDescription(item.getDescription());
                dto.setPrice(item.getPrice());
                return dto;
            }).toList();
            orderDTO.setServiceItems(itemDTOs);
        }

        return orderDTO;
    }
}
