package com.test.example.controller;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

import com.test.example.CreateSchema;
import com.test.example.DAO.AdministratorsDAO;
import com.test.example.Repository.*;
import com.test.example.entity.*;
import com.test.example.service.CustomersService;

@Controller
public class IndexController {
	 @Autowired
	private CustomersService CustomersService; 
	 @Autowired
	private AdministratorsDAO AdministratorsDAO; 
 
	public RestTemplate restTemplate; 	 
	 
//	String result = restTemplate
//			.getForObject("http://localhost:8080/, "42", "21");
	 
	 
	@RequestMapping("/")
    public String viewHomePage() throws SQLException {

		
		return "index";} 
	
	
	
	public static String CEmail; 
	public static String CEmail() {return CEmail;} 

	@RequestMapping(value="CLogin", method =RequestMethod.POST )
	public String isValidUser(ModelMap map, 
	@RequestParam(value="c_email", required = true) String email, 
	@RequestParam(value="c_pwd", required = true) String pwd) 
	{Customers Cust = CustomersService.authenticate(email, pwd);	
	if (Cust == null) {
		map.addAttribute("errorMessage", "Invalid login credentials");
		return "index";}	
	CEmail=email; 
      return "Welcome";}	  
	
  
	
	
	
	@RequestMapping(value="Register", method =RequestMethod.POST )
	public String Register(ModelMap map) {return "signup"; }	  
	
	
	@RequestMapping(value= "Admin", method =RequestMethod.POST )
	public String isValidUser(
	@RequestParam("a_id") String adminid, 
	@RequestParam("a_pwd") String adminpwd, ModelMap map) 	
	{try {
		//int adminid1 = Integer.parseInt(adminid);
	Administrators Admin = AdministratorsDAO.authenticate(adminid, adminpwd);
	String page ="index"; 
	if (Admin == null) {
		map.addAttribute("errorMessage1", "Invalid login credentials");
		return "index";}
	
      return "Administrator"; 
	    } 	catch(NumberFormatException N) {map.addAttribute("errorMessage1", "Invalid login credentials");
		return "index";} 
	    }
	
	
		
	 
	
	

 	 

 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
        
 
}