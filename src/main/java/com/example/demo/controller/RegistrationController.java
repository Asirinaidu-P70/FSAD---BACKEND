package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> createRegistration(@RequestBody RegistrationRequest request) {

        if (request.getUserId() == null || request.getWorkshopId() == null) {
            return ResponseEntity.badRequest().body("userId and workshopId are required");
        }

        Registration registration = new Registration();

        registration.setUserId(request.getUserId());
        registration.setWorkshopId(request.getWorkshopId());

        if (request.getRegistrationDate() != null && !request.getRegistrationDate().isBlank()) {
            registration.setRegistrationDate(request.getRegistrationDate());
        } else {
            registration.setRegistrationDate(LocalDateTime.now().toString());
        }

        Registration savedRegistration = registrationService.saveRegistration(registration);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistration);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getRegistrationsByUser(@PathVariable Long userId) {
        List<Registration> registrations = registrationService.getUserRegistrations(userId);
        return ResponseEntity.ok(registrations);
    }

    @GetMapping
    public ResponseEntity<?> getAllRegistrations() {
        return ResponseEntity.ok(registrationRepository.findAll());
    }
}