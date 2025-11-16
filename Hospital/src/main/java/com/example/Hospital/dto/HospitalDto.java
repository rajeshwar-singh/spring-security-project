package com.example.Hospital.dto;

import org.springframework.stereotype.Component;

@Component
public class HospitalDto {

    private String doctorName;

    private String doctorSpeciality;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }
}
