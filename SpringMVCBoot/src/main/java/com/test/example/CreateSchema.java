package com.test.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.test.example.entity.*;
import com.test.example.service.*;



@Component
@Controller
public class CreateSchema  {
	@Autowired
	private CustomersService CustServ;
	@Autowired
	private PurchaseService PurServ;
	@Autowired
	private ProductsService proServ;
	@Autowired
	public EntityManager em;
	
	public void Startdb() throws SQLException {  
			Statement stmt = null;
			Integer rs = null;		
			String name,pass,url;  
			Connection conn = null;  
       try {Class.forName("com.mysql.cj.jdbc.Driver");  
           url="jdbc:mysql://localhost:3306";  
           name="root";  
           pass="12345678";  
           conn = DriverManager.getConnection(url,name,pass);  
           System.out.println("Connection created");  }  
           catch (Exception e) {  
           System.out.println(e.toString());  }  		
		try {stmt = conn.createStatement();
		    rs = stmt.executeUpdate("create schema SpringMVCBootTest;");}		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    stmt.close();
		    conn.close();
		    System.out.println("Connection closed");  return;} 
			stmt.close();  conn.close();	}

	public void CreatePurCusPro() throws SQLException {  
		Statement stmt = null;
		Integer rs = null;		
		String name,pass,url;  
		Connection conn = null;  
			try {Class.forName("com.mysql.cj.jdbc.Driver");  
           url="jdbc:mysql://localhost:3306/SpringMVCBootTest";  
           name="root";  
           pass="12345678";  
           conn = DriverManager.getConnection(url,name,pass);  
           System.out.println("Connection created");  }  
           catch (Exception e) {  
           System.out.println(e.toString());  
       }  
			try {
		    stmt = conn.createStatement();  
		    
		    rs = stmt.executeUpdate(
		    		"create table purchase_customers_pre\r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchases.purchase_id as purchase_id, \r\n"
		    		+ "purchases.date as purchase_date, \r\n"
		    		+ "purchases.quantity as purchase_quantity, \r\n"
		    		+ "purchases.purchase_amount as purchase_amount, \r\n"
		    		+ "purchases_customers_list.purchases_purchase_id as purchases_purchase_id,\r\n"
		    		+ "purchases_customers_list.customers_list_id as customers_list_id\r\n"
		    		+ "from purchases_customers_list \r\n"
		    		+ "LEFT outer JOIN purchases ON \r\n"
		    		+ "purchases.purchase_id = purchases_customers_list.purchases_purchase_id \r\n"
		    		+ "Union \r\n"
		    		+ "SELECT \r\n"
		    		+ "purchases.purchase_id as purchase_id, \r\n"
		    		+ "purchases.date as purchase_date, \r\n"
		    		+ "purchases.quantity as purchase_quantity, \r\n"
		    		+ "purchases.purchase_amount as purchase_amount, \r\n"
		    		+ "purchases_customers_list.purchases_purchase_id as purchases_purchase_id,\r\n"
		    		+ "purchases_customers_list.customers_list_id as customers_list_id\r\n"
		    		+ "from purchases_customers_list \r\n"
		    		+ "RIGHT outer JOIN purchases ON \r\n"
		    		+ "purchases.purchase_id = purchases_customers_list.purchases_purchase_id;\r\n"
		    		+ "");
		    
		    rs = stmt.executeUpdate(
		    		"create table purchase_customers_rev\r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_pre.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_pre.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_pre.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_pre.purchase_amount as purchase_amount, \r\n"
		    		+ "customers.id as customers_id, \r\n"
		    		+ "customers.fullname as fullname,\r\n"
		    		+ "customers.email as customers_email\r\n"
		    		+ "from customers\r\n"
		    		+ "LEFT outer JOIN purchase_customers_pre ON \r\n"
		    		+ "purchase_customers_pre.customers_list_id = customers.id \r\n"
		    		+ "Union \r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_pre.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_pre.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_pre.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_pre.purchase_amount as purchase_amount, \r\n"
		    		+ "customers.id as customers_id, \r\n"
		    		+ "customers.fullname as fullname,\r\n"
		    		+ "customers.email as customers_email\r\n"
		    		+ "from customers\r\n"
		    		+ "RIGHT outer JOIN purchase_customers_pre ON \r\n"
		    		+ "purchase_customers_pre.customers_list_id = customers.id;\r\n"
		    		+ "");
		    	
		    rs = stmt.executeUpdate(
		    		"create table purchase_customers_product_pre\r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_rev.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_rev.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_rev.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_rev.purchase_amount as purchase_amount, \r\n"
		    		+ "purchase_customers_rev.customers_id as customers_id, \r\n"
		    		+ "purchase_customers_rev.fullname as fullname,\r\n"
		    		+ "purchase_customers_rev. customers_email as customers_email,\r\n"
		    		+ "purchases_products_list. products_list_productsid as products_list_productsid\r\n"
		    		+ "from purchases_products_list\r\n"
		    		+ "LEFT outer JOIN purchase_customers_rev ON \r\n"
		    		+ "purchase_customers_rev.purchase_id = purchases_products_list.purchases_purchase_id\r\n"
		    		+ "Union \r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_rev.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_rev.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_rev.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_rev.purchase_amount as purchase_amount, \r\n"
		    		+ "purchase_customers_rev.customers_id as customers_id, \r\n"
		    		+ "purchase_customers_rev.fullname as fullname,\r\n"
		    		+ "purchase_customers_rev. customers_email as customers_email,\r\n"
		    		+ "purchases_products_list. products_list_productsid as products_list_productsid\r\n"
		    		+ "from purchases_products_list\r\n"
		    		+ "RIGHT outer JOIN purchase_customers_rev ON \r\n"
		    		+ "purchase_customers_rev.purchase_id = purchases_products_list.purchases_purchase_id;\r\n"
		    		+ "");
		    
		    rs = stmt.executeUpdate(
		    		"create table purchase_customers_product_rev\r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_product_pre.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_product_pre.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_product_pre.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_product_pre.purchase_amount as purchase_amount, \r\n"
		    		+ "purchase_customers_product_pre.customers_id as customers_id, \r\n"
		    		+ "purchase_customers_product_pre.fullname as fullname,\r\n"
		    		+ "purchase_customers_product_pre. customers_email as customers_email,\r\n"
		    		+ "purchase_customers_product_pre.products_list_productsid as productsid,\r\n"
		    		+ "products.brand  as products_brand,\r\n"
		    		+ "products.productname as product_name,\r\n"
		    		+ "products.price as unit_price\r\n"
		    		+ "from products\r\n"
		    		+ "LEFT outer JOIN purchase_customers_product_pre ON \r\n"
		    		+ "purchase_customers_product_pre. products_list_productsid = products.productsid\r\n"
		    		+ "Union \r\n"
		    		+ "SELECT  \r\n"
		    		+ "purchase_customers_product_pre.purchase_id as purchase_id, \r\n"
		    		+ "purchase_customers_product_pre.purchase_date as purchase_date, \r\n"
		    		+ "purchase_customers_product_pre.purchase_quantity as purchase_quantity, \r\n"
		    		+ "purchase_customers_product_pre.purchase_amount as purchase_amount, \r\n"
		    		+ "purchase_customers_product_pre.customers_id as customers_id, \r\n"
		    		+ "purchase_customers_product_pre.fullname as fullname,\r\n"
		    		+ "purchase_customers_product_pre. customers_email as customers_email,\r\n"
		    		+ "purchase_customers_product_pre.products_list_productsid as productsid,\r\n"
		    		+ "products.brand  as products_brand,\r\n"
		    		+ "products.productname as product_name,\r\n"
		    		+ "products.price as unit_price\r\n"
		    		+ "from products\r\n"
		    		+ "RIGHT outer JOIN purchase_customers_product_pre ON \r\n"
		    		+ "purchase_customers_product_pre. products_list_productsid = products.productsid;\r\n"
		    		+ "");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE purchase_id IS NULL;");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE purchase_date IS NULL;");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE purchase_quantity IS NULL;");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE purchase_amount IS NULL;");		    
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE customers_id IS NULL;");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE fullname IS NULL;");		    
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE customers_email IS NULL;");	
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE productsid IS NULL;");	
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE products_brand IS NULL;");	
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE product_name IS NULL;");
		    rs = stmt.executeUpdate("DELETE FROM purchase_customers_product_rev WHERE unit_price IS NULL;");
		    

		}
		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    stmt.close();
		    conn.close();
		    System.out.println("Connection closed");  return; 
		    
		} 

		 stmt.close();  conn.close();

		}
		
	
	public void delete_tables() throws SQLException {  
		Statement stmt = null;
		  Integer rs = null;		
		 String name,pass,url;  
       Connection conn = null;  
       try {  
           Class.forName("com.mysql.cj.jdbc.Driver");  
           url="jdbc:mysql://localhost:3306/SpringMVCBootTest";  
           name="root";  
           pass="12345678";  
           conn = DriverManager.getConnection(url,name,pass);  
           System.out.println("Connection created");  }  
           catch (Exception e) {  
           System.out.println(e.toString());  
       }  
			
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeUpdate("drop table purchase_customers_pre;");
		    rs = stmt.executeUpdate("drop table purchase_customers_product_pre;"); 
		    rs = stmt.executeUpdate("drop table purchase_customers_product_rev;");
		    rs = stmt.executeUpdate("drop table purchase_customers_rev;");		    		
		}
		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    stmt.close();
		    conn.close();
		    System.out.println("Connection closed");  return; 
		    
		} 

		 stmt.close();  conn.close();

		}
	
	
	
	
}

