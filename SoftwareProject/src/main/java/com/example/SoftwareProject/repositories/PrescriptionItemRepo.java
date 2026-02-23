package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionItemRepo extends JpaRepository<PrescriptionItem,Long> {
}
