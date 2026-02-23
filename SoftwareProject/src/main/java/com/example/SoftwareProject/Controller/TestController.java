package com.example.SoftwareProject.Controller;


import com.example.SoftwareProject.model.Medicine;
import com.example.SoftwareProject.repositories.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    MedicineRepo medicineRepo;

    @GetMapping("/medicines")
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    @GetMapping("/encode")
    public String encode() {
        return new BCryptPasswordEncoder().encode("1234");
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello, secured world!";
    }
}
