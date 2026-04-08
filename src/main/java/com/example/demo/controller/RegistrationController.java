package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://127.0.0.1:4173")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Registration saveRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    @GetMapping("/user/{userId}")
    public List<Registration> getUserRegistrations(@PathVariable Long userId) {
        return registrationService.getUserRegistrations(userId);
    }
}