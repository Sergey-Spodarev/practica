package org.example.practica.controller;

import lombok.AllArgsConstructor;
import org.example.practica.DTO.MechanicDTO;
import org.example.practica.service.MechanicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mechanicService")
@AllArgsConstructor
public class MechanicController {
    private final MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<List<MechanicDTO>> getAll() {
        return ResponseEntity.ok(mechanicService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mechanicService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MechanicDTO> create(@RequestBody MechanicDTO mechanicDTO) {
        return new ResponseEntity<>(mechanicService.create(mechanicDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MechanicDTO> update(@PathVariable Long id, @RequestBody MechanicDTO mechanicDTO) {
        return ResponseEntity.ok(mechanicService.update(id, mechanicDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mechanicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
