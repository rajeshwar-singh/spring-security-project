package com.example.Hospital.controller;

import com.example.Hospital.dto.DoctorDto;
import com.example.Hospital.entity.DoctorEntity;
import com.example.Hospital.repository.DoctorRepository;
import com.example.Hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    public String createDoctor(@RequestBody DoctorDto doctorDto)
    {
        return doctorService.addDoctor(doctorDto);
    }

    @GetMapping("/doctors")
    public List<DoctorDto> getDoctors()
    {
        return doctorService.getDoctors();
    }

}
