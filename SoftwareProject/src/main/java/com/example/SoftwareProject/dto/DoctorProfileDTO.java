package com.example.SoftwareProject.dto;

public class DoctorProfileDTO {

    private String name;
    private String specialization;
    private String email;
    private String phone;

    public DoctorProfileDTO(String name, String specialization,
                            String email, String phone) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
    }

    // getters
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
