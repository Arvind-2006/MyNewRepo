package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.dto.DashboardSummary;
import com.example.SoftwareProject.dto.DoctorProfileDTO;
import com.example.SoftwareProject.dto.DoctorRegistrationDTO;
import com.example.SoftwareProject.model.Doctor;
import com.example.SoftwareProject.model.Role;
import com.example.SoftwareProject.model.User;
import com.example.SoftwareProject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AdminDashboardService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public DoctorRepo doctorRepository;

    private final PasswordEncoder passwordEncoder;
    private final MedicineRepo medicineRepository;
    private final MedicineInventoryRepo inventoryRepository;
    private final DispenseLogRepo dispenseLogRepository;

    public AdminDashboardService(PasswordEncoder passwordEncoder,
                                 MedicineRepo medicineRepository,
                                 MedicineInventoryRepo inventoryRepository,
                                 DispenseLogRepo dispenseLogRepository) {
        this.passwordEncoder = passwordEncoder;
        this.medicineRepository = medicineRepository;
        this.inventoryRepository = inventoryRepository;
        this.dispenseLogRepository = dispenseLogRepository;
    }

    public DashboardSummary getDashboardSummary() {

        long totalMedicines = medicineRepository.count();

        long lowStockCount =
                inventoryRepository.countByQuantityAvailableLessThan(10);

        long expiredCount =
                inventoryRepository.countByExpiryDateBefore(LocalDate.now());

        LocalDateTime startOfDay =
                LocalDate.now().atStartOfDay();

        LocalDateTime endOfDay =
                LocalDate.now().atTime(23, 59, 59);

        long totalDispensedToday =
                dispenseLogRepository.countByDispenseTimeBetween(
                        startOfDay, endOfDay);

        return new DashboardSummary(
                totalMedicines,
                lowStockCount,
                expiredCount,
                totalDispensedToday
        );
    }
    public DoctorProfileDTO registerDoctor(DoctorRegistrationDTO request) {

        // 1️⃣ Create login account
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_DOCTOR);

        userRepository.save(user);

        // 2️⃣ Create doctor profile
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setPhone(request.getPhone());
        doctor.setEmail(request.getUsername()); // optional
        doctor.setUser(user);

        //doctorRepository.save(doctor);
       // return doctorRepository.save(doctor);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorProfileDTO(
                savedDoctor.getName(),
                savedDoctor.getSpecialization(),
                savedDoctor.getEmail(),
                savedDoctor.getPhone()
        );
    }

}

