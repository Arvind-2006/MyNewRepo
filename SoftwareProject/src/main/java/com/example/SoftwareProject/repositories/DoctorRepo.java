package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.Doctor;
import com.example.SoftwareProject.model.Patient;
import com.example.SoftwareProject.model.Prescription;
import com.example.SoftwareProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
//    Optional<Doctor> findByUserUsername(String username);
//
//    Optional<Object> findByUser(User user);

    Optional<Doctor> findByUser(User user);

    Optional<Patient> findByName(String name);

   // List<Prescription> findByPatient(Patient patient);

    Optional<Object> findByUserUsername(String username);
}

