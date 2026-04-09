package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findByUserId(Long userId);

    Registration findByUserIdAndWorkshopId(Long userId, Long workshopId);

    boolean existsByUserIdAndWorkshopId(Long userId, Long workshopId);
}