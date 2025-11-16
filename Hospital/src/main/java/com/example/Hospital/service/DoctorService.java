package com.example.Hospital.service;

import com.example.Hospital.dto.DoctorDto;
import com.example.Hospital.entity.DoctorEntity;
import com.example.Hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    public String addDoctor(DoctorDto doctorDto){
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDocterId(doctorDto.getDocterId());
        doctorEntity.setDoctorSpeciality(doctorDto.getDoctorSpeciality());
        doctorEntity.setDoctorName(doctorDto.getDoctorName());
        doctorEntity.setDoctorFees(doctorDto.getDoctorFees());
        doctorRepository.save(doctorEntity);
        return "Doctor Created";
    }

    public List<DoctorDto> getDoctors()
    {
        return entityToDto();
    }

    private List<DoctorDto> entityToDto()
    {
        List<DoctorEntity> response = doctorRepository.findAll();
        List<DoctorDto> doctors = new ArrayList<>();

        for(DoctorEntity doctor : response)
        {
            DoctorDto doc = new DoctorDto();
            doc.setDocterId(doctor.getDocterId());
            doc.setDoctorSpeciality(doctor.getDoctorSpeciality());
            doc.setDoctorName(doctor.getDoctorName());
            doc.setDoctorFees(doctor.getDoctorFees());
            doctors.add(doc);
        }
        return doctors;
    }
}
