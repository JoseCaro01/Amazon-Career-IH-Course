package com.ironhack.lab402.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.lab402.models.Doctor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PatientDTO {
    @NotNull()
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull(message = "No puede ser nulo")
    private Long admittedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Long admittedBy) {
        this.admittedBy = admittedBy;
    }
}
