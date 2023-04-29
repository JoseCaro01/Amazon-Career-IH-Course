package com.ironhack.lab402.dto;

import com.ironhack.lab402.enums.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DoctorDTO {
    @NotNull
    @Min(1)
    private Long doctorId;
    @NotNull
    private Status status;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
