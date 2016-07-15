package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Patient;

public interface PatientService {
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Patient> listPatient();

	@Secured({"ROLE_ADMIN"})
	void insertPatient(Patient patient);
	
	@Secured({"ROLE_ADMIN"})
	void deletePatient(Integer patID);

	@Secured({"ROLE_ADMIN"})
	Patient findPatientById(Integer patID);

}
