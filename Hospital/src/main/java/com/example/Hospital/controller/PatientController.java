package com.example.Hospital.controller;

import com.example.Hospital.dto.PatientDto;
import com.example.Hospital.entity.PatientEntity;
import com.example.Hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody PatientDto patientDto)
    {
        String response = patientService.createPatient(patientDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }
}
