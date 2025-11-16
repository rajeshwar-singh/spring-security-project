package com.example.Hospital.service;

import com.example.Hospital.dto.DoctorDto;
import com.example.Hospital.dto.HospitalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class HopitalService {

    @Autowired
    private DoctorService doctorService;

    public List<HospitalDto> getDoctors()
    {
        List<DoctorDto> doctorDtos = doctorService.getDoctors();
        List<HospitalDto> doctors = new ArrayList<>();

        for(DoctorDto dt : doctorDtos)
        {
            HospitalDto hospitalDto = new HospitalDto();
            hospitalDto.setDoctorName(dt.getDoctorName());
            hospitalDto.setDoctorSpeciality(dt.getDoctorSpeciality());
            doctors.add(hospitalDto);
        }
        return doctors;
    }
}
