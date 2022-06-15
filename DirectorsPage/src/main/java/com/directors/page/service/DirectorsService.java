package com.directors.page.service;
import java.util.List;
import com.directors.page.domain.Directors;

public interface DirectorsService {
	public List<Directors> findAll();
	public Directors findById(long Id);
 
	

}
 
