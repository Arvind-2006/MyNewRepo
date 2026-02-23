package com.example.SoftwareProject.exceptions;

public class MedicineExpiredException extends RuntimeException {
    public MedicineExpiredException(String message) {
        super(message);
    }
}
