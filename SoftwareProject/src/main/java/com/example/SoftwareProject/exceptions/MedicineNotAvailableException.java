package com.example.SoftwareProject.exceptions;

public class MedicineNotAvailableException extends RuntimeException {
    public MedicineNotAvailableException(String message) {
        super(message);
    }
}
