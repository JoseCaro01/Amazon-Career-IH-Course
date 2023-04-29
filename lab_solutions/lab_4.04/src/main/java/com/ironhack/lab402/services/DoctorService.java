package com.ironhack.lab402.services;

import com.ironhack.lab402.dto.DoctorDTO;
import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Long id) {
        if (doctorRepository.findById(id).isPresent()) return doctorRepository.findById(id).get();
        return null;
    }

    public List<Doctor> findDoctorsByStatus(Status status) {
        return doctorRepository.findByStatus(status);
    }

    public List<Doctor> findDoctorsByDepartment(Department department) {
        return doctorRepository.findByDepartment(department);

    }

    public Doctor insertDoctor(Doctor doctor) {
        if(doctorRepository.findById(doctor.getEmployeeId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El doctor ya existe");
        }
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorStatus(Status newStatus,Long doctorId) {
        if(doctorRepository.findById(doctorId).isPresent() || newStatus !=null) {
            Doctor doctor =doctorRepository.findById(doctorId).get();
            doctor.setStatus(newStatus);
            return doctorRepository.save(doctor);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El doctor no existe");
    }

    public Doctor updateDoctorStatusDTO(DoctorDTO doctorDTO) {
        if(doctorRepository.findById(doctorDTO.getDoctorId()).isPresent()) {
            Doctor doctor =doctorRepository.findById(doctorDTO.getDoctorId()).get();
            doctor.setStatus(doctorDTO.getStatus());
            return doctorRepository.save(doctor);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El doctor no existe");
    }


}
