package com.example.Hospital.service;

import com.example.Hospital.dto.PatientDto;
import com.example.Hospital.entity.PatientEntity;
import com.example.Hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;




    public String createPatient(PatientDto patientDto)
    {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientId(patientDto.getPatientId());
        patientEntity.setPatientName(patientDto.getPatientName());
        patientEntity.setEmail(patientDto.getEmail());
        patientEntity.setProblem(patientDto.getProblem());
        patientEntity.setDisease(patientDto.getDisease());
        patientEntity.setAge(patientDto.getAge());

        patientRepository.save(patientEntity);
        return "Patient Created.";
    }

    public List<PatientDto> getPatients()
    {

       return doaPatients();
    }

    public List<PatientDto> doaPatients()
    {
        List<PatientEntity> res = patientRepository.findAll();
        List<PatientDto> ans = new ArrayList<>();
        for(PatientEntity patient : res)
        {
            PatientDto patientDto = new PatientDto();
            patientDto.setPatientId(patient.getPatientId());
            patientDto.setPatientName(patient.getPatientName());
            patientDto.setEmail(patient.getEmail());
            patientDto.setProblem(patient.getProblem());
            patientDto.setDisease(patient.getDisease());
            patientDto.setAge(patient.getAge());
            ans.add(patientDto);

        }
        return ans;
    }
}
