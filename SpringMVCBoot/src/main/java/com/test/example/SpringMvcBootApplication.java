package com.test.example;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class SpringMvcBootApplication {
	public static void main(String[] args) throws SQLException {	 
		CreateSchema crs = new CreateSchema(); 
		try {crs.Startdb();		
		} catch (SQLException e) 
		{System.out.println("Unable to Create Database"); }
		
		
		ApplicationContext applicationcontext = SpringApplication.run(SpringMvcBootApplication.class, args);}		

	
	
}
