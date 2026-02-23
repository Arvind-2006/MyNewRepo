package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Long> {
    long count();

}
