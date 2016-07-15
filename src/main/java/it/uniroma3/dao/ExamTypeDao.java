package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.ExamType;
import it.uniroma3.model.Indicator;
import it.uniroma3.model.Prerequisite;

public interface ExamTypeDao {
	
	List<ExamType> listExamType();
	
	ExamType findExamTypeById(Integer examTypeId);

	void insertExamType(ExamType examType);

	void deleteExamType(Integer examTypeId);

	void updateExamTypePrerequisites(Integer examTypeId, List<Prerequisite> prerequisites);

	void updateExamTypeIndicator(Integer examTypeId, Indicator indicator);

}
