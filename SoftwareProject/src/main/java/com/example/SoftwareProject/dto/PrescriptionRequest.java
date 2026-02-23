package com.example.SoftwareProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PrescriptionRequest {
    private String patientName;
    private String diagnosis;
    private List<ItemRequest> items;
}

