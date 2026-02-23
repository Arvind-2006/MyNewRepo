package com.example.SoftwareProject.Controller;

import com.example.SoftwareProject.Service.DoctorService;
import com.example.SoftwareProject.dto.PrescriptionRequest;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        return ResponseEntity.ok(
                doctorService.getProfile(authentication.getName())
        );
    }

    @PostMapping("/prescription")
    public ResponseEntity<?> createPrescription(
            @RequestBody PrescriptionRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                doctorService.createPrescription(request, authentication.getName())
        );
    }

    @GetMapping("/prescriptions")
    public ResponseEntity<?> getMyPrescriptions(Authentication authentication) {
        return ResponseEntity.ok(
                doctorService.getMyPrescriptions(authentication.getName())
        );
    }

    @GetMapping("/medicines")
    public ResponseEntity<?> getAvailableMedicines() {
        return ResponseEntity.ok(
                doctorService.getAvailableMedicines());
    }
}

