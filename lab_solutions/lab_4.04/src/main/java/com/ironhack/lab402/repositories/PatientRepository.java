package com.ironhack.lab402.repositories;

import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    public List<Patient> findByAdmittedByDepartment(Department department);

    public List<Patient> findByAdmittedByStatus(Status status);

    @Query("SELECT p from Patient p WHERE dateOfBirth BETWEEN :start AND :end")
    public List<Patient> findByDates(@Param("start") LocalDate start, @Param("end") LocalDate end);

    @Query("SELECT p from Patient p JOIN Doctor d ON d.employeeId = p.admittedBy WHERE d.department = :department")
    public List<Patient> findByDepartment(@Param("department") Department department);

    @Query("SELECT p from Patient p JOIN Doctor d ON d.employeeId = p.admittedBy WHERE d.status = :status")
    public List<Patient> findByStatus(@Param("status") Status status);
}
