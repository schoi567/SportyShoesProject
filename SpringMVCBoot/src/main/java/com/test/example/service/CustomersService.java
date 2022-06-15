package com.test.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.test.example.DAO.CustomersDAO;
import com.test.example.entity.Administrators;
import com.test.example.entity.Customers; 

@Component
@RepositoryRestResource(path="Customers")
public class CustomersService {	
	@Autowired
	private CustomersDAO CustDAO;

	@Transactional
	public Customers authenticate(String email, String pwd) {
		return CustDAO.authenticate(email, pwd);
	}
	
	@Transactional
	public Customers authenticateid(Long id, String pwd) {
		return CustDAO.authenticateid(id, pwd);}
 
	
	@Transactional
	public Customers getCustId(Long customerid) {
		return CustDAO.getCustId(customerid);
	}	
	
	@Transactional
	public Customers getCustEmail(String email) {
		return CustDAO.getCustEmail(email);
	}		
	

	@Transactional
	public void updatecPwd(Customers cust) {
		CustDAO.updatecPwd(cust);	
	}
	
	@Transactional
	public List<Customers> getAllCustomers(){	
		return (List<Customers>) CustDAO.getAllCustomers();

	}
	
	

	}