 package com.Dossierclient.assuré;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping(value = "/api/plannings")

public class planningRestApi {
	
	private String title = "Hello, I'm the planning Microservice";
	@Autowired
	private planningService planningService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<planning> createAssuré(@RequestBody planning planning) {
		return new ResponseEntity<>(planningService.addAssuré(planning), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<planning> updateAssuré(@PathVariable(value = "id") int id,
    										@RequestBody planning planning){
		return new ResponseEntity<>(planningService.updateAssuré(id, planning), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteAssuré(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(planningService.deleteAssuré(id), HttpStatus.OK);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<planning> getAllCandidats(){
		return planningService.GetCandidats();
	}

}
