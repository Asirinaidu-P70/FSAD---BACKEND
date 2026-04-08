package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ContactMessage;
import com.example.demo.service.ContactMessageService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://127.0.0.1:4173")
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping
    public ContactMessage saveMessage(@RequestBody ContactMessage message) {
        return contactMessageService.saveMessage(message);
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAllMessages();
    }
}