package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Indicator;

public interface IndicatorService {
	
	List<Indicator> listIndicator();

	List<Indicator> listIndicatorForType(Integer examTypeId);

	@Secured({"ROLE_ADMIN"})
	void insertIndicator(Indicator indicator);
	
	@Secured({"ROLE_ADMIN"})
	void deleteIndicator(Integer indId);


}
