package com.test.example.controller;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.example.DAO.*;
import com.test.example.entity.*;
import com.test.example.service.*;


@Controller
@RepositoryRestResource(path="customers")
@Transactional
public class CustomersController {
	@Autowired
	private CustomersDAO CustDAO;
	@Autowired
	private CustomersService CustServ;	
	@Autowired
	public EntityManager em;	
		@RequestMapping(value = "custpwchange1", method = RequestMethod.POST)
	    public String updatePasswordC (ModelMap map,  @RequestParam("email") String email,
	    		 @RequestParam("cpwd") String cpwd) throws SQLException
	    {if (email.equals("")) {map.addAttribute("errorMessage2", "email input empty");return "customerpwchange"; }
		 if (cpwd.equals("")) 
		 { map.addAttribute("errorMessage2", "password input empty"); return "customerpwchange"; }
		 try {
		 Customers Cust = CustServ.getCustEmail(email); 	 
		 Cust.setPwd(cpwd);  	
		// going straight to updatePwd will cause null pointers because mysql cannot read querylanuage directly. 
		 CustServ.updatecPwd(Cust);  		 
		 map.addAttribute("Success", "Password change successful"); 		  
			return "CustPWChangeSuccess";  
	    } 
		 
		 catch (NullPointerException e) 
		 {map.addAttribute("errorMessage2", "email input not found"); return "customerpwchange";} 		  
	    }
	
		
		
		 @GetMapping(value="customer_lookup")
		 	public String CustomerLookup ()
		    {return "CustomerLookup";   } 
			 
		 
		 
			 
	



	
	

	
}








