package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.Prescription;
import com.example.SoftwareProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepo extends JpaRepository<Prescription,Long> {
    List<Prescription> findByStatus(String pending);
    List<Prescription> findByDoctor(User doctor);

}
