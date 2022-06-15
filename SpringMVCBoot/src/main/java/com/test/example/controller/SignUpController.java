package com.test.example.controller;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.example.entity.Customers;

@Controller
@RepositoryRestResource(path="Customers")
//@Component
@Transactional
public class SignUpController {
	@Autowired
	EntityManager em; 
	
	@RequestMapping(value= "signup1", method =RequestMethod.POST )
 	public String AddCustomers(@RequestParam("email") String email, 
 			@RequestParam("password") String password, 
 			@RequestParam("fullname") String fullname, 
			@RequestParam("CCnumber") String CCnumber, 
 			@RequestParam("CCType") String CCType, 	
 			ModelMap map) throws SQLException 
 	{
		if (email.equals("")) 
 	{map.addAttribute("errorMessage3", "Everything has to be filled");
 	return "signup"; }
		if (password.equals("")) 
	 	{map.addAttribute("errorMessage3", "Everything has to be filled");
	 	return "signup"; }		
		if (fullname.equals("")) 
	 	{map.addAttribute("errorMessage3", "Everything has to be filled");
	 	return "signup"; }	
		
 	Customers c = 
 	new Customers(email, password, fullname, CCnumber, CCType); 
 	em.persist(c); 

 
 	
 	
 	return "RegisterSuccess";
 	}   
	
	
	
	@RequestMapping(value="MainPage1", method =RequestMethod.POST )
	public String BacktoMain(ModelMap map) {

		return "index"; }	
	

	
	
	
	
}

	
 
	

