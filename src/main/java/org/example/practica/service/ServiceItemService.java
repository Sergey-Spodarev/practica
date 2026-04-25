package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.ServiceItemDTO;
import org.example.practica.model.Order;
import org.example.practica.model.ServiceItem;
import org.example.practica.repository.OrderRepository;
import org.example.practica.repository.ServiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceItemService {
    private ServiceItemRepository serviceItemRepository;
    private OrderRepository orderRepository;

    public ServiceItemDTO create(ServiceItemDTO serviceItemDTO) {
        ServiceItem serviceItem = new ServiceItem();
        serviceItem.setDescription(serviceItemDTO.getDescription());
        serviceItem.setPrice(serviceItemDTO.getPrice());

        Order order = orderRepository.findById(serviceItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        serviceItem.setOrder(order);

        return convertToDTO(serviceItemRepository.save(serviceItem));
    }

    public List<ServiceItemDTO> getAll() {
        return serviceItemRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public ServiceItemDTO getById(Long id) {
        ServiceItem serviceItem = serviceItemRepository.findById(id).orElseThrow();
        return convertToDTO(serviceItem);
    }

    public ServiceItemDTO update(Long id, ServiceItemDTO serviceItemDTO) {
        ServiceItem serviceItem = serviceItemRepository.findById(id).orElseThrow();
        serviceItem.setDescription(serviceItemDTO.getDescription());
        serviceItem.setPrice(serviceItemDTO.getPrice());
        return convertToDTO(serviceItemRepository.save(serviceItem));
    }

    public void delete(Long id) {
        serviceItemRepository.deleteById(id);
    }

    private ServiceItemDTO convertToDTO(ServiceItem serviceItem) {
        ServiceItemDTO dto = new ServiceItemDTO();
        dto.setId(serviceItem.getId());
        dto.setDescription(serviceItem.getDescription());
        dto.setPrice(serviceItem.getPrice());
        dto.setOrderId(serviceItem.getOrder().getId());
        return dto;
    }

}
