package com.ironhack.lab402.repositories;

import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    public List<Doctor> findByStatus(Status status);

    // findByNameOrderByNameAsc


    public List<Doctor> findByDepartment(Department department);
}
