package com.example.SoftwareProject.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('PATIENT')")
public class PatientDashboardController {

    @GetMapping("/patient/dashboard")
    public String patientDashboard() {
        return "Patient Dashboard - Access Granted";
    }
}
