package com.example.SoftwareProject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "medicine_inventory")
public class MedicineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    private String batchNo;
    private int quantityAvailable;
    private LocalDate expiryDate;
    private int reorderLevel;
    private String machineSlot;

    private LocalDateTime lastUpdated;
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
    }

}
