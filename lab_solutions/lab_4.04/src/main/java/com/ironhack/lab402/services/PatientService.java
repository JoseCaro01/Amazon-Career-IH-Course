package com.ironhack.lab402.services;


import com.ironhack.lab402.dto.PatientDTO;
import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.models.Patient;
import com.ironhack.lab402.repositories.DoctorRepository;
import com.ironhack.lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        if (patientRepository.findById(id).isPresent()) return patientRepository.findById(id).get();
        return null;
    }

    public List<Patient> findByDates(LocalDate start, LocalDate end) {
        System.out.println(start.toString());
        //  return patientRepository.findByDateOfBirthBetween(start, end);
        return patientRepository.findByDates(start, end);
    }

    public List<Patient> findByDoctorDepartment(Department department) {
        //return patientRepository.findByAdmittedByDepartment(department);
        return patientRepository.findByDepartment(department);
    }

    public List<Patient> findByDoctorStatus(Status status) {

        //return patientRepository.findByAdmittedByStatus(status);

        return patientRepository.findByStatus(status);
    }

    public Patient insertPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(PatientDTO patientDTO) {
        if(patientRepository.findById(patientDTO.getId()).isPresent()) {
            Patient patient =patientRepository.findById(patientDTO.getId()).get();
            if(patientDTO.getDateOfBirth() != null) {
                patient.setDateOfBirth(patientDTO.getDateOfBirth());
            }
            if(patientDTO.getAdmittedBy()!=null && doctorRepository.findById(patientDTO.getAdmittedBy()).isPresent()) {
                patient.setAdmittedBy(doctorRepository.findById(patientDTO.getAdmittedBy()).get());
            }
            if(patientDTO.getName() !=null && !patient.getName().isEmpty()) {
                patient.setName(patientDTO.getName());
            }
            return patientRepository.save(patient);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El paciente no existe");
    }

    public void deletePatient(Long idPatient) {
        patientRepository.deleteById(idPatient);
    }

}
