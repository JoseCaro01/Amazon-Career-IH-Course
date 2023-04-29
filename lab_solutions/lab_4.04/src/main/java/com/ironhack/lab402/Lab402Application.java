package com.ironhack.lab402;

import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.models.Patient;
import com.ironhack.lab402.repositories.DoctorRepository;
import com.ironhack.lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Lab402Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab402Application.class, args);
	}

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Override
	public void run(String... args) throws Exception {
		Doctor doctor=doctorRepository.save(
				new Doctor(1L, Department.CARDIOLOGY,"Jose", Status.ON,
		List.of(new Patient())));

		Doctor doctor2=doctorRepository.save(
				new Doctor(2L, Department.CARDIOLOGY,"Ana", Status.ON,
						List.of(new Patient())));


		Patient patient = patientRepository.save(new Patient("Jose", LocalDate.now(),doctor));


	}
}
