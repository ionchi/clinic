package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Indicator;
import it.uniroma3.model.Prerequisite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ExamTypeDao;
import it.uniroma3.model.ExamType;

@Service
public class ExamTypeServiceImpl implements ExamTypeService {
	
	@Autowired
	private ExamTypeDao examTypeDao;

	@Override
	public List<ExamType> listExamType() {
		return this.examTypeDao.listExamType();
	}

	@Override
	public void insertExamType(ExamType examType) {
		this.examTypeDao.insertExamType(examType);
	}

	@Override
	public void deleteExamType(Integer examTypeId) {
		this.examTypeDao.deleteExamType(examTypeId);
	}

	@Override
	public void updateExamTypePrerequisites(Integer examTypeId, List<Prerequisite> prerequisites) {
		this.examTypeDao.updateExamTypePrerequisites(examTypeId, prerequisites);
	}

	@Override
	public void updateExamTypeIndicator(Integer examTypeId, Indicator indicator) {
		this.examTypeDao.updateExamTypeIndicator(examTypeId, indicator);
	}

	@Override
	public ExamType findExamTypeById(Integer examTypeId) {
		return this.examTypeDao.findExamTypeById(examTypeId);
	}

}
