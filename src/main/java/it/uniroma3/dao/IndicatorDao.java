package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Indicator;

public interface IndicatorDao {
	
	List<Indicator> listIndicator();

	List<Indicator> listIndicatorForType(Integer examTypeId);

	void insertIndicator(Indicator indicator);

	void deleteIndicator(Integer indId);

}
