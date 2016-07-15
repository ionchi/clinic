package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Exam;

public interface ExamDao {
	
	List<Exam> listExam();

	void insertExam(Exam exam);

	void deleteExam(Integer examId);
	
	List<Exam> listExamPatient(String username);

}
