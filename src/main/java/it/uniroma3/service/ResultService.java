package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Result;

public interface ResultService {
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Result> listResult();

	@Secured({"ROLE_ADMIN"})
	void insertPrerequisite(Result result);
	
	@Secured({"ROLE_ADMIN"})
	void deleteResult(Integer resId);


}
