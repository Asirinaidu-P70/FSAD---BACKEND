package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Workshop;
import com.example.demo.service.WorkshopService;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public List<Workshop> getAllWorkshops() {
        return workshopService.getAllWorkshops();
    }

    @GetMapping("/{id}")
    public Workshop getWorkshopById(@PathVariable Long id) {
        return workshopService.getWorkshopById(id);
    }

    @PostMapping
    public Workshop createWorkshop(@RequestBody Workshop workshop) {
        return workshopService.saveWorkshop(workshop);
    }

    @PutMapping("/{id}")
    public Workshop updateWorkshop(@PathVariable Long id, @RequestBody Workshop workshop) {
        return workshopService.updateWorkshop(id, workshop);
    }

    @DeleteMapping("/{id}")
    public String deleteWorkshop(@PathVariable Long id) {
        workshopService.deleteWorkshop(id);
        return "Workshop deleted successfully";
    }
}