package com.example.SoftwareProject.exceptions;

public class InvalidPrescriptionException extends RuntimeException {
    public InvalidPrescriptionException(String message) {
        super(message);
    }
}
