package com.example.Hospital.controller;

import com.example.Hospital.dto.HospitalDto;
import com.example.Hospital.service.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hopital")
public class HospitalController {

    @Autowired
    private HopitalService hopitalService;
    @GetMapping("/public/doctor/list")
    public List<HospitalDto> doctors()
    {
        return hopitalService.getDoctors();
    }
}
