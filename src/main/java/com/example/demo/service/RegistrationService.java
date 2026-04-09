package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.model.User;
import com.example.demo.model.Workshop;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkshopRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    public Registration saveRegistration(Registration registration) {

        if (registration.getUserId() == null) {
            throw new RuntimeException("userId is required");
        }

        if (registration.getWorkshopId() == null) {
            throw new RuntimeException("workshopId is required");
        }

        User user = userRepository.findById(registration.getUserId()).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Workshop workshop = workshopRepository.findById(registration.getWorkshopId()).orElse(null);

        if (workshop == null) {
            throw new RuntimeException("Workshop not found");
        }

        Registration existingRegistration =
                registrationRepository.findByUserIdAndWorkshopId(
                        registration.getUserId(),
                        registration.getWorkshopId()
                );

        if (existingRegistration != null) {
            throw new RuntimeException("User already registered for this workshop");
        }

        if (registration.getRegistrationDate() == null || registration.getRegistrationDate().isBlank()) {
            registration.setRegistrationDate(LocalDate.now().toString());
        }

        return registrationRepository.save(registration);
    }

    public List<Registration> getUserRegistrations(Long userId) {
        return registrationRepository.findByUserId(userId);
    }
}