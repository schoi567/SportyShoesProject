package com.test.example.controller;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import com.test.example.Repository.*;
import com.test.example.entity.*;
import com.test.example.service.*;
import com.test.example.DAO.*;
import org.hibernate.Query;

@Controller
@RepositoryRestResource(path="products")
@Transactional
public class ProductPageController {
	@Autowired
	EntityManager em;
	@Autowired
	private WelcomePageController WPC; 	
	@Autowired	
	public ProductsService PS; 
	
	
 
	  @RequestMapping(value = "deleteproduct{id}", method = RequestMethod.GET)
	  public String DeleteProduct(@PathVariable("id") int id ) 
	  {  System.out.print(id); 
		  PS.deleteProduct(id);
  
		  return "deleteproduct";} 
	  
	  
	 @GetMapping(value = "Delete_go_back")
	  public String DeletePage() 
	  { 
		  return "ProdList";} 
	  

}
	
	




