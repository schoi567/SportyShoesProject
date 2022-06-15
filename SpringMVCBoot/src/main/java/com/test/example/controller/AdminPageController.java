package com.test.example.controller;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import com.test.example.entity.*;
import com.test.example.service.*;
import com.test.example.CreateSchema;
import com.test.example.DAO.*;
 

@Controller
@RepositoryRestResource(path="administrators")
@Transactional
public class AdminPageController {

	@Autowired
	private AdminService AdminService;
	@Autowired
	public ProductsService ProdService;
	@Autowired	
	EntityManager em;
	@Autowired
	public CreateSchema SC;		
	@GetMapping(value = "addproduct")
	    public String AddProduct() {return "addproduct";} 
	 @GetMapping(value = "addproduct1")
	   public ModelAndView AddProduct1(ModelMap map,
	    	@RequestParam(value = "brand") BrandType brand,
	    	@RequestParam(value = "productname", required = false) String productname,	    		
    		@RequestParam(value = "color") ColorType color,	    		
    		@RequestParam(value = "size", required = false) BigDecimal size,	    
    		@RequestParam(value = "price", required = false) BigDecimal price) 
	   {if (productname.equals("")|| size==null || price==null) 
		{ModelAndView model1 = new ModelAndView("addproduct");
		 model1.addObject("errorMessage", "Everything has to filled");	 
		 return model1; } 		 
		Products prod = new Products(brand, productname, color, size, price);
		em.persist(prod);					
		ModelAndView model = new ModelAndView("addproduct2");
		model.addObject("success", prod.toString());		
		System.out.println(prod.toString());	return model;} 

	  @RequestMapping(value = "adminpwchange", method = RequestMethod.POST)
	    public String updatePassword(ModelMap map,  @RequestParam("acid") String aid,
	    		 @RequestParam("acpwd") String acpwd) throws SQLException
	    {if (aid.equals("")) {map.addAttribute("errorMessage2", "id input empty");return "Administrator"; }
		 if (acpwd.equals("")) 
		 { map.addAttribute("errorMessage2", "password input empty"); return "Administrator"; }
		 try {
		 Administrators Admin = AdminService.getAdminId(aid); 
		  Admin.setPwd(acpwd);  
		// going straight to updatePwd will cause null pointers because mysql cannot read querylanuage directly. 
		  AdminService.updatePwd(Admin); 
		  map.addAttribute("Success", "Password change successful"); 		  
			return "AdminPWChange";  } 
		 
		 catch (NullPointerException e) 
		 {map.addAttribute("errorMessage2", "id input not found"); return "Administrator";}  }
	  
	  @RequestMapping(value = "CustomerList", method = RequestMethod.POST)
	    public String CustomerList() 
	        {return "CustomerList";} 
	    
	  @RequestMapping(value = "BrandList", method = RequestMethod.POST)
	    public String ProdList() 
	        {return "ProdList";} 
	  
	  @RequestMapping(value = "purchaselist", method = RequestMethod.POST)
	    public String purchase_list() throws SQLException 
	  {	SC.delete_tables();  SC.CreatePurCusPro(); return "PurchaseList";} 
	  
	
		@RequestMapping(value = "BacktoAdmin", method = RequestMethod.POST)
	    public String backtoAdmin() 
	    {return "Administrator";} 

	  

		@RequestMapping(value = "customername", method = RequestMethod.POST)
	    public String customername(ModelMap map,  
	    		 @RequestParam("customer_name") String customer_name)throws SQLException
	        {map.addAttribute("customername", customer_name); 
	        return "CustomerSearchResult";} 

		
		@GetMapping("date_lookup")
	    public String DateLookup() 
	    {return "DateLookupPurchase";} 
		
		
		@RequestMapping(value = "Date", method = RequestMethod.POST)
	    public String GetPurchaseInfoByDate(ModelMap map,  
	    		 @RequestParam("selected_date") Date date)throws SQLException
	    {  
			System.out.println(date); 
	    map.addAttribute("dateresult", date); 
	    String pattern = "yyyy-MM-dd";
	    DateFormat df = new SimpleDateFormat(pattern);
	    String Selected_Date = df.format(date);
	    System.out.println(date); 
	    map.addAttribute("Selected_Date", Selected_Date); 

	    return "DateSearchResult";} 
		
		
 
		
		@GetMapping("customerid_lookup")
	    public String PurchaseLookup() 
	    {return "PurchaseLookupCustomerid";} 
		
		
		@PostMapping("purchasecustomerid")
	    public String PurchaseLookupwithcustomerid(ModelMap map, 
	    		@RequestParam("purchasecustomerid") String customerid) 
	  { map.addAttribute("customersearchid", customerid); 
			
			
			return "PurchaseLookupCustomeridResult";} 
	    
	 

}



		
		
	









