package com.example.SoftwareProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private String gender;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Patient() {}

    public Patient(String name, Integer age, String gender,
                   String email, String phone, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}