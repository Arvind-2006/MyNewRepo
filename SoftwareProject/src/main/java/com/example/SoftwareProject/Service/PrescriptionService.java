package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.dto.ItemRequest;
import com.example.SoftwareProject.dto.PrescriptionRequest;
import com.example.SoftwareProject.model.*;
import com.example.SoftwareProject.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//
//@Service
//public class PrescriptionService {
//
//    @Autowired
//    private PrescriptionRepo prescriptionRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private DoctorRepo doctorRepository;
//    @Autowired
//    private PatientRepo patientRepository;
//
//    public Prescription createPrescription(Prescription prescription) {
//
//        prescription.setStatus("ACTIVE");   // default status
//        prescription.setExpiryDate(LocalDate.now().plusDays(7)); // optional logic
//
//        return prescriptionRepository.save(prescription);
//    }
//    public Prescription getPrescriptionById(Long id) {
//        return prescriptionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Prescription not found"));
//    }
//
//
//    @Transactional
//    public Prescription createPrescription(
//            PrescriptionRequest request,
//            Authentication authentication) {
//
//        String username = authentication.getName();
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow();
//
//        Doctor doctor = doctorRepository.findByUser(user)
//                .orElseThrow();
//
//        Patient patient = patientRepository
//                .findByName(request.getPatientName())
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
//
//        // Create main prescription
//        Prescription prescription = new Prescription();
//        prescription.setDoctor(doctor);
//        prescription.setPatient(patient);
//        prescription.setDiagnosis(request.getDiagnosis());
//        prescription.setDate(LocalDate.now());
//
//        Prescription savedPrescription =
//                prescriptionRepository.save(prescription);
//
//        // Create prescription items
//        for (ItemRequest item : request.getItems()) {
//
//            Medicine medicine = medicineRepository
//                    .findById(item.getMedicineId())
//                    .orElseThrow();
//
//            PrescriptionItem prescriptionItem =
//                    new PrescriptionItem();
//
//            prescriptionItem.setPrescription(savedPrescription);
//            prescriptionItem.setMedicine(medicine);
//            prescriptionItem.setQuantity(item.getQuantity());
//
//            prescriptionItemRepository.save(prescriptionItem);
//        }
//
//        return savedPrescription;
//    }
//}



@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepo prescriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepo doctorRepository;

    @Autowired
    private PatientRepo patientRepository;

    @Autowired
    private MedicineRepo medicineRepository;

    @Autowired
    private PrescriptionItemRepo prescriptionItemRepository;

    @Transactional
    public Prescription createPrescription(
            PrescriptionRequest request,
            Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow();

        Doctor doctor = doctorRepository.findByUser(user)
                .orElseThrow();

        Patient patient = (Patient) patientRepository
                .findByName(request.getPatientName())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor.getUser());
        //What to put here
        prescription.setDoctor(doctor.getUser());

        prescription.setDiagnosis(request.getDiagnosis());
        prescription.setPatientName(patient.getName());
        prescription.setDiagnosis(request.getDiagnosis());
        prescription.setPrescribedAt(LocalDate.now().atStartOfDay());
        prescription.setStatus("ACTIVE");
        prescription.setExpiryDate(LocalDate.now().plusDays(7));

        Prescription savedPrescription =
                prescriptionRepository.save(prescription);

//
//
        List<PrescriptionItem> prescriptionItems = new ArrayList<>();

        for (ItemRequest item : request.getItems()) {
            Medicine medicine = medicineRepository.findById(item.getMedicineId())
                    .orElseThrow();

            PrescriptionItem prescriptionItem = new PrescriptionItem();
            prescriptionItem.setPrescription(savedPrescription);
            prescriptionItem.setMedicine(medicine);
            prescriptionItem.setQuantity(item.getQuantity());

            prescriptionItemRepository.save(prescriptionItem);
            prescriptionItems.add(prescriptionItem); // add to list
        }

// attach the items to the prescription
        savedPrescription.setItems(prescriptionItems);

        return savedPrescription;
//        for (ItemRequest item : request.getItems()) {
//
//            Medicine medicine = medicineRepository
//                    .findById(item.getMedicineId())
//                    .orElseThrow();
//
//            PrescriptionItem prescriptionItem =
//                    new PrescriptionItem();
//
//            prescriptionItem.setPrescription(savedPrescription);
//            prescriptionItem.setMedicine(medicine);
//            prescriptionItem.setQuantity(item.getQuantity());
//
//            prescriptionItemRepository.save(prescriptionItem);
//        }
//
//        return savedPrescription;
    }
}
