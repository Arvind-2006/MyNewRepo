//package com.example.SoftwareProject.Controller;
//
//import com.example.SoftwareProject.Service.InventoryService;
//import com.example.SoftwareProject.model.MedicineInventory;
//import com.example.SoftwareProject.repositories.MedicineInventoryRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//public class InventoryController {
//
//    @Autowired
//    private MedicineInventoryRepo inventoryRepo;
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping("/inventory")
//    public List<MedicineInventory> getAllStock() {
//        return inventoryRepo.findAll();
//    }
//
//    @PostMapping("/inventory/add")
//    public ResponseEntity<?> addBatch(@RequestBody MedicineInventory inventory) {
//        return ResponseEntity.ok(inventoryService.addBatch(inventory));
//    }
//
//    @PutMapping("/inventory/{id}")
//    public ResponseEntity<?> updateStock(@PathVariable Long id,
//                                         @RequestParam int quantity) {
//        System.out.println("UPDATE API HIT -> ID: " + id + ", QTY: " + quantity);
//        return ResponseEntity.ok(inventoryService.updateStock(id, quantity));
//    }
//
//    @GetMapping("/inventory/low-stock")
//    public ResponseEntity<?> lowStock() {
//        return ResponseEntity.ok(inventoryService.getLowStock());
//    }
//
//    @GetMapping("/inventory/expired")
//    public ResponseEntity<?> expired() {
//        return ResponseEntity.ok(inventoryService.getExpired());
//    }
//}
