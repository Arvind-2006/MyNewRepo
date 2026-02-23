package com.example.SoftwareProject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@Entity
//public class Prescription {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long prescriptionId;
//
//    private Long patientId;
//
//    @ManyToOne
//    @JoinColumn(name = "medicine_id")
//    private Medicine medicine;
//
//    private int quantityPrescribed;
//    private String dosage;
//    private LocalDate expiryDate;
//    private String status;
//}
@Getter
@Setter
@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private String diagnosis;

    private LocalDateTime prescribedAt;

    @ManyToOne
    private User doctor;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<PrescriptionItem> items;

    private String status;

    private LocalDate expiryDate;

}
