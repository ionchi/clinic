package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Exam;

public interface ExamService {
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Exam> listExam();
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Exam> listExamPatient(String nomePaziente);

	@Secured({"ROLE_ADMIN"})
	void insertExam(Exam exam);
	
	@Secured({"ROLE_ADMIN"})
	void deleteExam(Integer examId);

}
