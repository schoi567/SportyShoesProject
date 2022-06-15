package com.test.example.controller;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.test.example.entity.*;

@Controller
@Transactional
public class DirectorController {

	
	private static final String BASE_URL ="http://localhost:8080/Directors";

	private RestTemplate restTemplate;
	

	

	@Autowired
	public DirectorController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();}  
	
	@RequestMapping(value ="DirectorsPath")
	public String DirectorsPath()  {
	return "Directors";} 
	
	
	@GetMapping(path="/Directors")  
	public ModelAndView listOfTodos() {
		
		ResponseEntity<List<Directors>> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Directors>>() {
				});
	
		
		List<Directors> Directors = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("DirectorsList");
	 
		modelAndView.addObject("Directors", Directors);
		
		return modelAndView;
	}
	
	
 
	
	@GetMapping(path = "/Directors/showFormForAdd")
	public ModelAndView showFormForAddTodos() {
		
		ModelAndView modelAndView = new ModelAndView("Directors-Form");
		
		Directors Directors = new Directors();
		
		modelAndView.addObject("Directors", Directors);
		
		return modelAndView;
	}
	
	
	/* 
	@PostMapping(path = "/users/todos/saveTodos")
	public ModelAndView saveTodo(@ModelAttribute("todos") Todo theTodo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/todos");
		theTodo.setUsername("vinodh"); // bad code
		restTemplate.postForObject(BASE_URL, theTodo, Todo.class);
		

		return modelAndView;
	}
	
	*/
	
	
	@GetMapping(path = "/Directors/showFormForUpdate")
	public ModelAndView showFormForUpdateTodos(@RequestParam("DirectorId") Long Id,Model theModel) {
		
		Map<String, Long> params = new HashMap<>();
		params.put("Id", Id);
		
		Directors Directors = restTemplate.getForObject(BASE_URL + "/{Id}", Directors.class, params);
		theModel.addAttribute("Directors", Directors);
		return new ModelAndView("Directors-Form");
		
	}
	


	/* 
	
	@GetMapping(path = "/users/todos/delete")
	public ModelAndView deleteTodos(@RequestParam("todoId") Long theId) {
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		restTemplate.delete(BASE_URL+"/{theId}",params);
		
		
		ResponseEntity<List<Todo>> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Todo>>() {
				});
		
		List<Todo> todos = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("list-todos");
		
		modelAndView.addObject("todos", todos);
		
		return modelAndView;
		
	}		*/

	
}
