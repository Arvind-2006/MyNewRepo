package com.example.SoftwareProject.dto;

public class PatientProfileDTO {

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String address;

    public PatientProfileDTO(String name, Integer age,
                             String gender, String email,
                             String phone, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getGender() { return gender; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}
