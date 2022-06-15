package com.test.example.ErrorHandler;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.example.controller.WelcomePageController;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException; 



@RestControllerAdvice
@ControllerAdvice(basePackages = {"com.test.example.controller"})

public class ErrorHandler extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(value=NumberFormatException.class)	  
	 public String ERROR() 
	 {return "NumberFormatException -> Please type correct format";}
	 
		 @ExceptionHandler(value=SQLIntegrityConstraintViolationException.class)	  
		 public ModelAndView ERROR3(SQLIntegrityConstraintViolationException SE) 
		 { ModelAndView model2 = new ModelAndView("signup");
		 model2.addObject("errorMessage2", SE.getMessage());
		 return model2;}
	 
	
	 @ExceptionHandler(value=MethodArgumentTypeMismatchException.class)
	 public ModelAndView ERROR1(MethodArgumentTypeMismatchException me, HttpServletRequest request, HttpServletResponse response) {	

		 	String uri = request.getRequestURI();
		 	System.out.println(uri);
		 	
		 	if (uri.equals("/Date")) 
		 	{ModelAndView model1 = new ModelAndView("DateLookupPurchase");
		 	model1.addObject("errorMessage", "Please Select Date.");
            return model1;
		 	} 
	
		 	 ModelAndView model = new ModelAndView("cancelpurchase");
			 model.addObject("errorMessage1", "Customerid should be number.");
             return model;
	  }
	 
	 
	 
	 
	 
	 
	 @ExceptionHandler(value=IllegalStateException.class)
	 public String ERROR2() {
		 { 
			return "Signals that a method has been invoked at an illegal or inappropriate time. In other words, the Java environment or Java application is not in an appropriate state for the requested operation."; } 
	  }	 

	 
	 
	 
	
}
