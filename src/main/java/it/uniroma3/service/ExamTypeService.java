package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Indicator;
import it.uniroma3.model.Prerequisite;
import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.ExamType;

public interface ExamTypeService {

	List<ExamType> listExamType();
	
	ExamType findExamTypeById(Integer examTypeId);

	@Secured({"ROLE_ADMIN"})
	void insertExamType(ExamType examType);
	
	@Secured({"ROLE_ADMIN"})
	void deleteExamType(Integer examTypeId);

	@Secured({"ROLE_ADMIN"})
	void updateExamTypePrerequisites(Integer examTypeId, List<Prerequisite> prerequisites);

	@Secured({"ROLE_ADMIN"})
	void updateExamTypeIndicator(Integer examTypeId, Indicator indicator);
	
}
