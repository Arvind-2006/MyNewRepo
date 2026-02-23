package com.example.SoftwareProject.repositories;

import com.example.SoftwareProject.model.Medicine;
import com.example.SoftwareProject.model.MedicineInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicineInventoryRepo extends JpaRepository<MedicineInventory,Long> {
    MedicineInventory findByMedicine_MedicineId(Long medicineId);

    List<MedicineInventory> findByQuantityAvailableLessThan(int quantity);
    List<MedicineInventory> findByExpiryDateBefore(LocalDate date);

   //Optional<Object> findByMedicine(Medicine medicine);

    Optional<MedicineInventory> findByMedicine(Medicine medicine);
    long countByQuantityAvailableLessThan(int threshold);

    long countByExpiryDateBefore(LocalDate date);

}
