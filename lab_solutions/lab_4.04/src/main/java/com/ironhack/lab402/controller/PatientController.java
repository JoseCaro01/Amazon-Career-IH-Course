package com.ironhack.lab402.controller;


import com.ironhack.lab402.dto.PatientDTO;
import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.models.Patient;
import com.ironhack.lab402.services.DoctorService;
import com.ironhack.lab402.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("patient/find-all")
    public List<Patient> findAll() {
        return patientService.findAllPatient();
    }

    @GetMapping("patient/find-by-id/{id}")
    public Patient findById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("patient/find-by-date/{start}/{end}")

    public List<Patient> findByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        return patientService.findByDates(start, end);
    }

    @GetMapping("patient/find-by-department/{department}")
    public List<Patient> findByDepartment(@PathVariable Department department) {
        return patientService.findByDoctorDepartment(department);
    }

    @GetMapping("patient/find-by-status/{status}")
    public List<Patient> findByDepartment(@PathVariable Status status) {
        return patientService.findByDoctorStatus(status);
    }


    @PostMapping("patient/save")
    public Patient insertPatient(@RequestBody Patient patient) {
        return patientService.insertPatient(patient);
    }

    @PutMapping("patient/update")
    public Patient updatePatient(@RequestBody  PatientDTO patientDTO) {
        return patientService.updatePatient(patientDTO);
    }

    @DeleteMapping("patient/delete/{patientId}")
    public void deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
    }


}
