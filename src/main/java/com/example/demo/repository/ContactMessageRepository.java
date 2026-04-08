package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

}