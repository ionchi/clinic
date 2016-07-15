package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteService {
	
	List<Prerequisite> listPrerequisite();

	List<Prerequisite> listPrerequisiteForType(Integer examTypeId);

	@Secured({"ROLE_ADMIN"})
	void insertPrerequisite(Prerequisite prerequisite);
	
	@Secured({"ROLE_ADMIN"})
	void insertPreToType(Integer examTypeId, Prerequisite prerequisite);
	
	@Secured({"ROLE_ADMIN"})
	void deletePrerequisite(Integer preId);

}
