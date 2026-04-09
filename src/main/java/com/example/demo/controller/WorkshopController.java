package com.example.demo.controller;

import com.example.demo.dto.WorkshopRequest;
import com.example.demo.model.Workshop;
import com.example.demo.repository.WorkshopRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopRepository workshopRepository;

    @GetMapping
    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkshopById(@PathVariable Long id) {
        Workshop workshop = workshopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workshop not found"));

        return ResponseEntity.ok(workshop);
    }

    @PostMapping
    public ResponseEntity<?> createWorkshop(@Valid @RequestBody WorkshopRequest request) {

        Workshop workshop = new Workshop();
        workshop.setTitle(request.getTitle());
        workshop.setCategory(request.getCategory());
        workshop.setDate(request.getDate());
        workshop.setTime(request.getTime());
        workshop.setDescription(request.getDescription());
        workshop.setSeatsAvailable(request.getSeatsAvailable());
        workshop.setPrice(request.getPrice());

        Workshop savedWorkshop = workshopRepository.save(workshop);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkshop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorkshop(
            @PathVariable Long id,
            @RequestBody WorkshopRequest request
    ) {

        Workshop workshop = workshopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workshop not found"));

        workshop.setTitle(request.getTitle());
        workshop.setCategory(request.getCategory());
        workshop.setDate(request.getDate());
        workshop.setTime(request.getTime());
        workshop.setDescription(request.getDescription());
        workshop.setSeatsAvailable(request.getSeatsAvailable());
        workshop.setPrice(request.getPrice());

        Workshop updatedWorkshop = workshopRepository.save(workshop);

        return ResponseEntity.ok(updatedWorkshop);
    }
}