package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Result;

public interface ResultDao {
	
	List<Result> listResult();

	void insertResult(Result result);

	void deleteResult(Integer resId);

}
