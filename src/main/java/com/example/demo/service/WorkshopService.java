package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Workshop;
import com.example.demo.repository.WorkshopRepository;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    public Workshop getWorkshopById(Long id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public Workshop saveWorkshop(Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Workshop updateWorkshop(Long id, Workshop workshop) {
        Workshop existingWorkshop = workshopRepository.findById(id).orElse(null);

        if (existingWorkshop != null) {
            existingWorkshop.setTitle(workshop.getTitle());
            existingWorkshop.setCategory(workshop.getCategory());
            existingWorkshop.setTrainerName(workshop.getTrainerName());
            existingWorkshop.setTrainerRole(workshop.getTrainerRole());
            existingWorkshop.setDescription(workshop.getDescription());
            existingWorkshop.setDate(workshop.getDate());
            existingWorkshop.setTime(workshop.getTime());
            existingWorkshop.setSeats(workshop.getSeats());
            existingWorkshop.setRating(workshop.getRating());
            existingWorkshop.setStatus(workshop.getStatus());
            existingWorkshop.setImageUrl(workshop.getImageUrl());

            return workshopRepository.save(existingWorkshop);
        }

        return null;
    }

    public void deleteWorkshop(Long id) {
        workshopRepository.deleteById(id);
    }
}