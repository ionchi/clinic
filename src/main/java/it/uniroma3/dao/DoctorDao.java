package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

public interface DoctorDao {
	
	List<Doctor> listDoctor();

	void insertDoctor(Doctor doctor);

	void deleteDoctor(Integer docId);
	
	List<Exam> findExamsByDoctor(String firstName, String lastName);
	
	Doctor findDoctorById(Integer docId);
}
