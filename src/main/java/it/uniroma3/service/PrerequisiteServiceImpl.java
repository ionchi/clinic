package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PrerequisiteDao;
import it.uniroma3.model.Prerequisite;

@Service
public class PrerequisiteServiceImpl implements PrerequisiteService{
	
	@Autowired
	private PrerequisiteDao prerequisiteDao;

	@Override
	public List<Prerequisite> listPrerequisite() {
		return this.prerequisiteDao.listPrerequisite();
	}

	@Override
	public List<Prerequisite> listPrerequisiteForType(Integer examTypeId) {
		return this.prerequisiteDao.listPrerequisiteForType(examTypeId);
	}

	@Override
	public void insertPrerequisite(Prerequisite prerequisite) {
		this.prerequisiteDao.insertPrerequisite(prerequisite);
	}

	@Override
	public void deletePrerequisite(Integer preId) {
		this.prerequisiteDao.deletePrerequisite(preId);
	}

	@Override
	public void insertPreToType(Integer examTypeId, Prerequisite prerequisite) {
		this.prerequisiteDao.insertPreToType(examTypeId, prerequisite);
	} 

}
