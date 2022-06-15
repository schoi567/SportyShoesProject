package com.test.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.test.example.DAO.*;
import com.test.example.entity.*; 

@Component
@RepositoryRestResource(path="Products")
public class ProductsService {	
	@Autowired
	private ProductsDAO ProDAO;
	
	
	
	
	@Transactional
	public Products getProductsId(int id) {
		return ProDAO.getProductsId(id);
	}
	
	
	@Transactional
	public void deleteProduct(int id) {
		 ProDAO.deleteProduct(id);
	}
	
	@Transactional
	public List<Products> getAllProducts(){
		return (List<Products>) ProDAO.getAllProducts();
	}

 
}


	
	
	
	
 










