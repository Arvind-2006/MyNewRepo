package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUserUsername(String username);
}

