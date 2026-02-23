package com.example.SoftwareProject.Service;

import com.example.SoftwareProject.model.Medicine;
import com.example.SoftwareProject.repositories.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    public Medicine updateMedicine(Long id, Medicine updated) {
        Medicine medicine = medicineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setMedicineName(updated.getMedicineName());
        medicine.setManufacturer(updated.getManufacturer());
        medicine.setPrice(updated.getPrice());

        return medicineRepo.save(medicine);
    }

    public void deleteMedicine(Long id) {
        medicineRepo.deleteById(id);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }
}
