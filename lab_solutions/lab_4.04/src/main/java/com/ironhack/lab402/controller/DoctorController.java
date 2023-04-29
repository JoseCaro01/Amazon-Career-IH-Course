package com.ironhack.lab402.controller;

import com.ironhack.lab402.dto.DoctorDTO;
import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("doctor/find-all")
    public List<Doctor> findAll() {
        return doctorService.findAllDoctor();
    }



    @GetMapping("doctor/find-by-id")
    public Doctor findById(@RequestParam Long id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping("doctor/find-by-status/{status}")
    public List<Doctor> findByStatus(@PathVariable Status status) {
        return doctorService.findDoctorsByStatus(status);
    }

    @GetMapping("doctor/find-by-department/{department}")
    public List<Doctor> findByStatus(@PathVariable Department department) {
        return doctorService.findDoctorsByDepartment(department);
    }

    @PostMapping("doctor/save")
    public Doctor insertDoctor(@RequestBody Doctor doctor) {
        return doctorService.insertDoctor(doctor);
    }

    @PatchMapping("doctor/update-status/{doctorId}/{status}")
    public Doctor updateStatus(@PathVariable Long doctorId,@PathVariable Status status){
        return doctorService.updateDoctorStatus(status,doctorId);
    }
    @PatchMapping("doctor/update-status")
    public Doctor updateStatusDTO(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctorStatusDTO(doctorDTO);

    }
}
