//package com.example.SoftwareProject.Controller;
//
//
//import com.example.SoftwareProject.Service.PrescriptionService;
//import com.example.SoftwareProject.model.Prescription;
//import com.example.SoftwareProject.repositories.PrescriptionRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("admin/prescriptions")
//public class PrescriptionController {
//
//    @Autowired
//    PrescriptionRepo prescriptionRepo;
//
//    @Autowired
//    private PrescriptionService prescriptionService;
//
//    @GetMapping
//    public List<Prescription> getAll() {
//        return prescriptionRepo.findAll();
//    }
//
//    @GetMapping("/pending")
//    public List<Prescription> getPending() {
//        return prescriptionRepo.findByStatus("PENDING");
//    }
//
//    @PutMapping("/{id}/approve")
//    public ResponseEntity<?> approve(@PathVariable Long id) {
//        Prescription p = prescriptionRepo.findById(id).get();
//        p.setStatus("APPROVED");
//        return ResponseEntity.ok(prescriptionRepo.save(p));
//    }
//
//    @PostMapping("/add")
//    public Prescription createPrescription(@RequestBody Prescription prescription) {
//        return prescriptionService.createPrescription(prescription);
//    }
//}
