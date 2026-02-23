package com.example.SoftwareProject.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorDashboardController {

    @GetMapping("/doctor/dashboard")
    public String doctorDashboard() {
        return "Doctor Dashboard - Access Granted";
    }
}
