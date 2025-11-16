package com.example.Hospital.dto;

import org.springframework.stereotype.Component;

@Component
public class DoctorDto {

    private Integer docterId;
    private String doctorSpeciality;
    private String doctorName;
    private String doctorFees;

    public Integer getDocterId() {
        return docterId;
    }

    public void setDocterId(Integer docterId) {
        this.docterId = docterId;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorFees() {
        return doctorFees;
    }

    public void setDoctorFees(String doctorFees) {
        this.doctorFees = doctorFees;
    }
}
