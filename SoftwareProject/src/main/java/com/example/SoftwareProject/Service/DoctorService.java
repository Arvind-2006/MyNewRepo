package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.dto.DoctorProfileDTO;
import com.example.SoftwareProject.dto.ItemRequest;
import com.example.SoftwareProject.dto.PrescriptionRequest;
import com.example.SoftwareProject.model.*;
import com.example.SoftwareProject.repositories.DoctorRepo;
import com.example.SoftwareProject.repositories.MedicineRepo;
import com.example.SoftwareProject.repositories.PrescriptionRepo;
import com.example.SoftwareProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepo doctorRepository;

    public DoctorService(DoctorRepo doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Add Doctor
    public Doctor addDoctor(Doctor doctor) {

        // find user using email (assuming username = email)
//        User user = userRepository.findByUsername(doctor.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        doctor.setUser(user);   // 🔥 VERY IMPORTANT

        return doctorRepository.save(doctor);
    }


    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Update Doctor
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));

        doctor.setName(updatedDoctor.getName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setPhone(updatedDoctor.getPhone());

        return doctorRepository.save(doctor);
    }

    // Delete Doctor
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

//    public User getProfile(String username) {
//
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("Doctor not found"));
//    }
    public DoctorProfileDTO getProfile(String username) {

        Doctor doctor = (Doctor) doctorRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return new DoctorProfileDTO(
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getEmail(),
                doctor.getPhone()
        );
    }


    public Prescription createPrescription(PrescriptionRequest request, String username) {

        User doctor = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Prescription prescription = new Prescription();
        prescription.setPatientName(request.getPatientName());
        prescription.setDiagnosis(request.getDiagnosis());
        prescription.setDoctor(doctor);
        prescription.setPrescribedAt(LocalDateTime.now());

        List<PrescriptionItem> items = new ArrayList<>();

        for (ItemRequest itemReq : request.getItems()) {

            Medicine medicine = medicineRepository.findById(itemReq.getMedicineId())
                    .orElseThrow(() -> new RuntimeException("Medicine not found"));

            PrescriptionItem item = new PrescriptionItem();
            item.setMedicine(medicine);
            item.setQuantity(itemReq.getQuantity());
            item.setPrescription(prescription);

            items.add(item);
        }

        prescription.setItems(items);

        return prescriptionRepository.save(prescription);
    }

    @Autowired
    private PrescriptionRepo prescriptionRepository;



    public List<Prescription> getMyPrescriptions(String username) {

        User doctor = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return prescriptionRepository.findByDoctor(doctor);
    }

    @Autowired
    private MedicineRepo medicineRepository;

    public List<Medicine> getAvailableMedicines() {
        return medicineRepository.findAll();
    }


}
