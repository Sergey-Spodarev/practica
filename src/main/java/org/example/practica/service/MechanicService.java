package org.example.practica.service;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.MechanicDTO;
import org.example.practica.model.Mechanic;
import org.example.practica.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public MechanicDTO create(MechanicDTO mechanicDTO) {
        Mechanic mechanic = new Mechanic();
        mechanic.setName(mechanicDTO.getName());
        mechanic.setSpecialization(mechanicDTO.getSpecialization());
        mechanic.setHireDate(mechanicDTO.getHireDate());
        return convertToDTO(mechanicRepository.save(mechanic));
    }

    public List<MechanicDTO> getAll() {
        return mechanicRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public MechanicDTO getById(Long id) {
        Mechanic mechanic = mechanicRepository.findById(id).orElseThrow();
        return convertToDTO(mechanic);
    }

    public MechanicDTO update(Long id, MechanicDTO mechanicDTO) {
        Mechanic mechanic = mechanicRepository.findById(id).orElseThrow();
        mechanic.setName(mechanicDTO.getName());
        mechanic.setSpecialization(mechanicDTO.getSpecialization());
        mechanic.setHireDate(mechanicDTO.getHireDate());
        return convertToDTO(mechanicRepository.save(mechanic));
    }

    public void delete(Long id) {
        mechanicRepository.deleteById(id);
    }

    private MechanicDTO convertToDTO(Mechanic mechanic) {
        MechanicDTO mechanicDTO = new MechanicDTO();
        mechanicDTO.setId(mechanic.getId());
        mechanicDTO.setName(mechanic.getName());
        mechanicDTO.setSpecialization(mechanic.getSpecialization());
        mechanicDTO.setHireDate(mechanic.getHireDate());
        return mechanicDTO;
    }
}
