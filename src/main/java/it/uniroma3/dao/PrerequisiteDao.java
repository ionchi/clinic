package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteDao {
	
	List<Prerequisite> listPrerequisite();

	void insertPrerequisite(Prerequisite prerequisite);
	
	void insertPreToType(Integer examTypeId, Prerequisite prerequisite);

	void deletePrerequisite(Integer preId);

	List<Prerequisite> listPrerequisiteForType(Integer examTypeId);

}
