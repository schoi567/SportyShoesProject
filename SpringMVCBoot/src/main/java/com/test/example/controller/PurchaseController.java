package com.test.example.controller;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.servlet.http.HttpSession;

import com.test.example.DAO.AdministratorsDAO;
import com.test.example.Repository.*;
import com.test.example.entity.*;
import com.test.example.service.*;

import io.netty.handler.codec.DateFormatter;

@Controller
public class PurchaseController {
	@Autowired
	EntityManager em; 
	@Autowired
	private PurchaseService PurSer; 
	@Autowired		
	public IndexController IdxC; 
	@Autowired
	private CustomersService CustServ;	
	@Autowired	
	public WelcomePageController WPC;
	@Autowired	
	private ProductsService ProServ;

	@Transactional	
    @RequestMapping(value="orderamount", method =RequestMethod.POST )
	public String AddPQuantity(ModelMap map,  
	@RequestParam(value="orderamount1", required = true) String orderamount1) throws SQLException
	{try	{int Amount =Integer.parseInt(orderamount1);  
	Purchases pur = new Purchases(); 
	 
	LocalDate now = LocalDate.now();  	
	pur.setQuantity(Amount); 
	pur.setDate(now);  
	Customers cust = CustServ.getCustEmail(IdxC.CEmail()); 
	pur.getCustomersList().add(cust); 
	Products prod = ProServ.getProductsId(WPC.PID()); 
	pur.getProductsList().add(prod); 		
	BigDecimal TotalPrice = BigDecimal.valueOf(Amount).multiply(prod.getPrice());
	pur.setPurchaseAmount(TotalPrice);
	em.persist(cust);	
	em.persist(prod);
	em.persist(pur);	
	//  here is where the problem begins 	
	System.out.println(WPC.PID()); 		
	System.out.println(prod.getBrand()); 	
	//	System.out.println(cust.getPwd());	
	map.addAttribute("TotalAmount", "Total Amount is: $"+  TotalPrice );	
	map.addAttribute("CreditCard", "$" + TotalPrice +" will be charged to your credit card with the credit card number " + cust.getCreditCardNumber() + "." );   	
	return "purchasesuccess"; 
	}catch(NumberFormatException e) {map.addAttribute("errorMessage1", "Please type in valid numbers");
	return "purchasepage"; }			
	
	
	
	
	
	
	}
 
	
	
	
	
	
	
  
  
 
	

 	 

 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
        
 
}