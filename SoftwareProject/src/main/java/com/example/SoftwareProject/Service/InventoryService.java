package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.model.MedicineInventory;
import com.example.SoftwareProject.repositories.MedicineInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private MedicineInventoryRepo inventoryRepo;

    public MedicineInventory addBatch(MedicineInventory batch) {
        return inventoryRepo.save(batch);
    }

    public MedicineInventory updateStock(Long id, int quantity) {
        MedicineInventory inv = inventoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inv.setQuantityAvailable(quantity);
        return inventoryRepo.save(inv);
    }

    public List<MedicineInventory> getLowStock() {
        return inventoryRepo.findByQuantityAvailableLessThan(10);
    }

    public List<MedicineInventory> getExpired() {
        return inventoryRepo.findByExpiryDateBefore(LocalDate.now());
    }
}
