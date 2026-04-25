package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.CarDTO;
import org.example.practica.model.Car;
import org.example.practica.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public CarDTO create(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setOwnerName(carDTO.getOwnerName());
        car.setOwnerPhone(carDTO.getOwnerPhone());
        return convertToDTO(carRepository.save(car));
    }

    public List<CarDTO> getAll() {
        return carRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public CarDTO getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow();
        return convertToDTO(car);
    }

    public CarDTO update(Long id, CarDTO carDTO) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setOwnerName(carDTO.getOwnerName());
        car.setOwnerPhone(carDTO.getOwnerPhone());
        return convertToDTO(carRepository.save(car));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setOwnerName(car.getOwnerName());
        carDTO.setOwnerPhone(car.getOwnerPhone());
        return carDTO;
    }
}
