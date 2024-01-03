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
@RequestMapping(value = "/api/reclamations")

public class reclamationRestApi {
	
	private String title = "Hello, I'm the reclamation Microservice";
	@Autowired
	private reclamationService reclamationService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<reclamation> createAssuré(@RequestBody reclamation reclamation) {
		return new ResponseEntity<>(reclamationService.addAssuré(reclamation), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<reclamation> updateAssuré(@PathVariable(value = "id") int id,
    										@RequestBody reclamation reclamation){
		return new ResponseEntity<>(reclamationService.updateAssuré(id, reclamation), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteAssuré(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(reclamationService.deleteAssuré(id), HttpStatus.OK);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<reclamation> getAllCandidats(){
		return reclamationService.GetCandidats();
	}

}
