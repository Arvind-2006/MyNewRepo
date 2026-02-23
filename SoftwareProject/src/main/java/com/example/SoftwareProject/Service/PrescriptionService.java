package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.model.Prescription;
import com.example.SoftwareProject.repositories.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepo prescriptionRepository;

    public Prescription createPrescription(Prescription prescription) {

        prescription.setStatus("ACTIVE");   // default status
        prescription.setExpiryDate(LocalDate.now().plusDays(7)); // optional logic

        return prescriptionRepository.save(prescription);
    }
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

}
