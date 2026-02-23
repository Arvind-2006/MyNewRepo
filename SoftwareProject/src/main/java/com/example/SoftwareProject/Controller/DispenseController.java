package com.example.SoftwareProject.Controller;

import com.example.SoftwareProject.Service.DispenseService;
import com.example.SoftwareProject.repositories.DispenseLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dispense")
public class DispenseController {

    @Autowired
    private DispenseService dispenseService;

    @Autowired
    private DispenseLogRepo dispenseLogRepo;

    @PostMapping("/{prescriptionId}")
    public ResponseEntity<?> dispense(@PathVariable Long prescriptionId) {
        try {
            return ResponseEntity.ok(dispenseService.dispenseMedicine(prescriptionId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/logs")
    public ResponseEntity<?> logs() {
        return ResponseEntity.ok(dispenseLogRepo.findAll());
    }






}
