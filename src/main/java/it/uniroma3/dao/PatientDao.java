package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Patient;

public interface PatientDao {

	List<Patient> listPatient();

	void insertPatient(Patient patient);

	void deletePatient(Integer patientId);

	Patient findPatientById(Integer patientId);
}
