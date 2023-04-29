package com.ironhack.lab402.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Doctor {

    @Id
    private Long employeeId;


    @Enumerated(EnumType.STRING)
    private Department department;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy") // SELECT * FROM DOCTOR JOIN PATIENT ON patient.id_doctor= id_doctor
    private List<Patient> patientList; // JOIN

    //@OneToOne - Un doctor tiene asociado un paciente tan solo uno y viceversa
    //@ManyToMany
    //private List<Patient> patient;

    public Doctor() {
    }

    public Doctor(Long employeeId, Department department, String name, Status status, List<Patient> patientList) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
        this.patientList = patientList;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
