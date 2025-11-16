package com.example.Hospital.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity

public class DoctorEntity {
    @Id
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
