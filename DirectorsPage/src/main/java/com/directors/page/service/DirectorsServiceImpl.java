package com.directors.page.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.directors.page.domain.Directors;
import com.directors.page.repository.DirectorsRepository;

@Service(value = "DirectorsService")
public class DirectorsServiceImpl implements DirectorsService{

	@Autowired
	private DirectorsRepository DirectorsRepository;
	
	//spring default constructor
	public DirectorsServiceImpl() {
		
	}
	
	public DirectorsServiceImpl(DirectorsRepository DirectorsRepository) {
		super();
		System.out.println("spring container called constructor to  assemble 'DirectorsRepository' bean");
		this.DirectorsRepository = DirectorsRepository;
	}

	public void setDirectorsRepository(DirectorsRepository DirectorsRepository) {
		System.out.println("spring container called setter method to  assemble 'DirectorRepository' bean");
		this.DirectorsRepository = DirectorsRepository;
	}

	@Override
	public List<Directors> findAll() {
		return DirectorsRepository.findAll();
	}
 
	
	@Override
	public Directors findById(long Id) {
		return DirectorsRepository.findById(Id).get();
	}

 

	
	
	
}
