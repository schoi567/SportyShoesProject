package com.directors.page.resource;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.directors.page.domain.Directors;
import com.directors.page.errors.DirectorsNotFoundException;
import com.directors.page.service.DirectorsService;

@RestController
public class DirectorsResource {
	@Autowired
	private DirectorsService DirectorsService;

	@GetMapping(path = "/Directors/{name}/{id}")
	public Directors getDirectors(@PathVariable String name, @PathVariable long id) {
		
		Directors Directors = DirectorsService.findById(id);
		if ( Directors == null ) {
			throw new DirectorsNotFoundException("id - " + id);
		}
		return Directors;
	}
	
	@GetMapping(path = "/Directors")
	public List<Directors> getAllDirectors() {
		return DirectorsService.findAll();
	}

 
	

}
