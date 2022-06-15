package com.test.example.controller;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import com.test.example.CreateSchema;
import com.test.example.entity.*;
import com.test.example.service.*;



@Controller
@RepositoryRestResource
@Transactional
public class WelcomePageController {
	@Autowired
	public CustomersService CustomersService; 
	@Autowired
	public PurchaseService PurSer; 
	@Autowired
	public CreateSchema SC;	
	@Autowired
	EntityManager em;

	public static int productid; 		
	public static int PID() {return productid;} 
	
	@RequestMapping(value ="custpwchange")
	public String viewHomePage() {return "customerpwchange";} 
	
	
 
	@RequestMapping(value ="cancelpurchase")
	public String cancelpurchase() throws SQLException{
	return "cancelpurchase";} 
	
 
	  
	
	
	@RequestMapping(value="customerid1", method =RequestMethod.POST )
	public String purchaseproduct1(ModelMap map,  
	@RequestParam(value="customerid", required = false) Long Lcustomerid,
	@RequestParam("password_verify") String password_verify) throws SQLException
	{ 
		Customers Cust = CustomersService.authenticateid(Lcustomerid, password_verify);
	if (Cust == null)
	{map.addAttribute("errorMessage", "Customerid or password is wrong");
	return "cancelpurchase"; } 

	SC.delete_tables();
	  SC.CreatePurCusPro();   
		String customerid = String.valueOf(Lcustomerid);  
		map.addAttribute("customerid", customerid);	
	return "cancelpurchase1";}   
	
	 
	

	
	
	@RequestMapping(value ="purchasecancel")
	public String cancelpurchasebyid(
		ModelMap map, 	
		@RequestParam("purid") String purid) throws SQLException {	
		long lpurid=Long.parseLong(purid);  
 
		PurSer.deletePurchase(lpurid);
 		
		return "cancelsuccess";} 
	
	

	@RequestMapping(value ="WelcomePage")
	public String WelcomePage() {return "Welcome";} 
	
 
	
	
	
	
 
 
	
	
	@RequestMapping(value ="RyanHaugland")
	public String viewHomePage1() {return "SeeProdDetails";} 
	
	@RequestMapping(value ="RyanHaugland1")
	public String viewHomePage2() {return "SeeProdDetails1";} 
	
	@RequestMapping(value ="RyanHaugland2")
	public String viewHomePage3() {return "SeeProdDetails2";} 
	
	
	@RequestMapping(value= "Welcomepage", method =RequestMethod.POST )
	public String Welcomepage() 
	{return "Welcome";}
	
	@RequestMapping(value= "LogOut", method =RequestMethod.GET )
	public String LogOut() 
	{return "index";}
 
	 
	
	
	
	@RequestMapping(value={"product{id}"}, method =RequestMethod.POST )
	public String purchaseproduct1(@PathVariable("id") int id) 
	{	productid = id; 
		return "purchasepage";}
	
	
	
		

		
	 
		

	 
} 
 	 
 	 
        
 